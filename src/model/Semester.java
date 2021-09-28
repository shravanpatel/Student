package model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.Data;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 28, 2021
 */

@Data
public class Semester {
	private int year; 
	private String name;
	private Course []courses;
	private double gpa;
	private int totalCourses = 0;
	
	public Semester() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int month = localDate.getMonthValue();
		this.year = localDate.getYear();
		String season;
		
		if(month < 5) {
			season = "Spring";
		} else if(month < 8) {
			season = "Summer";
		} else {
			season = "Fall";
		}
		this.name = season + " " + this.year;
		this.gpa = 0;
	}
	
	public void setCourses(Course []courses) {
		this.courses = courses;
		this.gpa = calculateGpa(courses);
		this.totalCourses = courses.length;
	}
	
	public void addCourse(Course course) {
		int newCourseIndex = totalCourses;
		for(int i = 0; i < totalCourses; i++) {
			if(courses[i].getName() == course.getName()) {
				break;
			} else {
				this.courses[newCourseIndex] = course;
				this.totalCourses++;
			}
		}
		
		this.gpa = calculateGpa(this.courses);
	}
	
	public void removeCourse(Course course) {
		int lastCourseIndex = totalCourses - 1;
		
		for(int i = 0; i < totalCourses; i++) {
			if(courses[i].getName() == course.getName()) {
				this.courses[lastCourseIndex] = null;
				this.totalCourses--;
				break;
			} 
		}
	}
	
	public double calculateGpa(Course []courses) {
		final String []gradeBracket = {"F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
		final double []gpaPoints = {0, 1, 1, 1.33, 1.67, 2, 2.33, 2.67, 3, 3.33, 3.67, 4};
		
		double points = 0;
		int COURSES = courses.length;
		for(int i = 0; i < COURSES; i++) {
			for(int j = 0; j < gradeBracket.length; j++) {
				if(courses[i].getGrade() == gradeBracket[j]) {
					points += gpaPoints[j];
				}
			}
		}
		return points/(double)COURSES;
	}
	
	public boolean isGpaGreaterThanThree() {
		return this.gpa > 3;
	}
	
	public boolean isGpaLessThanThree() {
		return this.gpa < 3;
	}
}

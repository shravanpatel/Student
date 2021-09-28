package model;

import java.util.Scanner;

public class StudentDriver {
	public static void main(String[] args) {
		Scanner userNameInput = new Scanner(System.in);
		Scanner userCoursesInput = new Scanner(System.in);
		Scanner userCourseNameInput = new Scanner(System.in);
		Scanner userCourseScoreInput = new Scanner(System.in);
		
		System.out.print("Enter students full name: ");
		String name = userNameInput.nextLine().trim();
		
		System.out.print("How many courses did the student take the semester? ");
		final int COURSES_TAKEN = userCoursesInput.nextInt();
		
		Course[] courses = new Course[COURSES_TAKEN];
		
		for(int i = 0; i < COURSES_TAKEN; i++) {
			System.out.print("Name of the course " + (i+1) + ": ");
			String courseName = userCourseNameInput.nextLine().trim();
			
			System.out.print("Final score in " + courseName + ": ");
			double courseScore = userCourseScoreInput.nextDouble();
			
			courses[i] = new Course(courseName, courseScore);
		}
		
		
		Semester semester = new Semester();
		semester.setCourses(courses);
		
		Student student = new Student(name);
		student.setSemester(semester);	
		
		
		System.out.println("\n" +student.getName() + "'s Grade Report for " + semester.getName());
		Course [] currentCourses = semester.getCourses();
		for(int i = 0; i < COURSES_TAKEN; i++) {
			System.out.println("\t" + currentCourses[i].getName() + " ---------- " + currentCourses[i].getGrade());
		}
		System.out.println("\nCumulative GPA: " + student.getGpa());
		
		 
		userNameInput.close();
		userCoursesInput.close();
		userCourseNameInput.close();
		userCourseScoreInput.close();
		
	}
}



package model;

import lombok.Data;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 28, 2021
 */

@Data
public class Student {
	private int id;
	private static int idCounter = 0;
	private String name;
	private String email;
	private double gpa;
	private Semester semester;
	
	public Student() {
		this.id = idCounter;
	}
	
	public Student(String name) {
		this.id = idCounter;
		this.name = name;
	}
	
	public double getGpa() {
		return semester.getGpa();
	}
}

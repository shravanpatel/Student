package model;

import lombok.Data;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 28, 2021
 */

@Data
public class Course {
	private int id;
	private int number;
	private String name;
	private int credits;
	private double score;
	private String grade;
	private final double []scoreBracket = {60, 63, 67, 70, 73, 77, 80, 83, 87, 90, 93, 100};
	private final String []gradeBracket = {"F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
	
	public Course() {
		
	}
	
	public Course(int id) {
		this.id = id;
	}
	
	public Course(String name) {
		this.name = name;
	}

	public Course(String name, double score) {
		this.name = name;
		this.score = score;
		
		for(int i = 0; i < gradeBracket.length; i++) {
			if(score < scoreBracket[i]) {
				this.grade = gradeBracket[i];
				break;
			}
		}
	}
}

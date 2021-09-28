package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Course;
import model.Semester;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 28, 2021
 */
public class SemesterTest {
	Semester semester = new Semester();
	final int TOTAL_COURSES = 2;
	Course []courses = new Course[TOTAL_COURSES];
	String course1Name = "Java II";
	double course1Score = 88.9;
	
	String course2Name = "C#";
	double course2Score = 94.5;
		
	double semesterGpa = 3.33;
	
	@Before
	public void setUp() throws Exception {
		courses[0] = new Course(course1Name, course1Score);
		courses[1] = new  Course(course2Name, course2Score);
		semester.setCourses(courses);
	}
		
	@Test
	public void testNumberOfSemesterCourses() {
		System.out.println("Inside testNumberOfSemesterCourses()");
		System.out.println(semester.getTotalCourses());
		assertEquals(TOTAL_COURSES, semester.getTotalCourses());
		
	}
	
	@Test
	public void testSemesterGpaAbove3() {
		System.out.println("Inside testSemesterGpaAboveThree()");
		System.out.println(semester.getGpa());
		assertTrue(semester.isGpaGreaterThanThree());
	}
	
	@Test
	public void testSemesterGpaBelow3() {
		System.out.println("Inside testSemesterGpaBelowThree()");
		System.out.println(semester.getGpa());
		assertFalse(semester.isGpaLessThanThree());
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Course;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 28, 2021
 */
public class CourseTest {
	String courseName = "Java II";
	double courseScore = 88.9;
	Course course = new Course(courseName, courseScore);
	String courseGrade = "B+";

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCourseName() {
		System.out.println("Inside testCourseName()");
		System.out.println(course.getName());
		assertEquals(courseName, course.getName());
	}
	
	@Test
	public void testCourseGrade() {
		System.out.println("Inside testCourseGrade()");
		System.out.println(course.getGrade());
		assertEquals(courseGrade, course.getGrade());
	}
	
	@Test
	public void testCourseScoreIsNotNull() {
		System.out.println("Inside testCourseScoreIsNotNull()");
		System.out.println(course.getScore());
		assertNotNull(course.getScore());
	}
}

package com.dharam.elearning.service;

import java.util.List;

import com.dharam.elearning.domain.Course;

public interface ICourseService {

	List<Course> findAllCourses();
	
	List<Course> findAllCourses(int page,int size);
	
	Course getCourse(long id);
	
	boolean addCourse(Course course);
	
	void deleteCourse(long course);
	
	void updateCourse(Course course);
	
}

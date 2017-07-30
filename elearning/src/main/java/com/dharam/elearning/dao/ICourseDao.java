package com.dharam.elearning.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dharam.elearning.domain.Course;

public interface ICourseDao {

	List<Course> findAllCourses();

	List<Course> findAllCourses(int page,int size);
	
	boolean addCourse(Course course);
	
	Course getCourse(long id);
	
	void deleteCourse(long courseId);
	
	void updateCourse(Course course);
}

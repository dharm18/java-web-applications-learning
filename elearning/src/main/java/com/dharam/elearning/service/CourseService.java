package com.dharam.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharam.elearning.dao.ICourseDao;
import com.dharam.elearning.domain.Course;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseDao courseDao;

	@Override
	public List<Course> findAllCourses() {
		return courseDao.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(int page, int size) {
		return courseDao.findAllCourses(page,size);
	}
	
	@Override
	public boolean addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public Course getCourse(long id) {
		return courseDao.getCourse(id);
	}  
	
	@Override
	public void deleteCourse(long courseId){
		courseDao.deleteCourse(courseId);
	}
	
	@Override
	public void updateCourse(Course course){
		courseDao.updateCourse(course);
	}
	
}

package com.dharam.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dharam.elearning.domain.Course;
import com.dharam.elearning.service.ICourseService;

@RestController
public class CourseController {

	@Autowired
	private ICourseService courseService;   
	
	//@RequestMapping(value="/course",method=RequestMethod.GET)
	@GetMapping(value = "/course",params={"page","size"})
	public @ResponseBody List<Course> index(@RequestParam("page") int page, @RequestParam("size") int size) {
		
		return courseService.findAllCourses(page,size);
	}
	
	@GetMapping(value = "/course")
	public @ResponseBody List<Course> index() {
		return courseService.findAllCourses();
	}
	
	@GetMapping("/course/{id}")
	public @ResponseBody Course getCourseById(@PathVariable long id) {
		Course course = courseService.getCourse(id);
		return course;
	}
	
	@PostMapping("/course")
	public ResponseEntity<Void> saveCourse(@RequestBody Course course){
		
		courseService.addCourse(course);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable long id){
		course.setId(id);
		courseService.updateCourse(course);
		return new ResponseEntity<Course>(HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable long id){
		courseService.deleteCourse(id);
		return new ResponseEntity<Course>(HttpStatus.OK);
	}
	
	
	
}

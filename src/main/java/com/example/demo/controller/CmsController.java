package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CmsService;

@RestController
public class CmsController {
	
	@Autowired
	private CmsService cmsService;
  
  //get the courses
  @GetMapping("/courses")
  public List<Course> getCourses(){
	return this.cmsService.getCourses();
  }
  
  //getCourse
  @GetMapping("/courses/{courseId}")
  public Course getCourse(@PathVariable String courseId){
	return this.cmsService.getCourse(Long.parseLong(courseId));
  }
  
  //adding course
  @PostMapping("/courses")
  public Course addCourse(@RequestBody Course course){
	return this.cmsService.addCourse(course);
  }
  
  //adding course
  @PutMapping("/courses")
  public Course updateCourse(@RequestBody Course course){
	return this.cmsService.updateCourse(course);
  }
  
  //delete Course
  @DeleteMapping("/courses/{courseId}")
  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	  try {
		  this.cmsService.deleteCourse(Long.parseLong(courseId));
		  return new ResponseEntity<>(HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  
  
}

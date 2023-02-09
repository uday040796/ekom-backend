package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;
import com.example.demo.entities.User;

public interface CmsService {
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long parseLong);
}

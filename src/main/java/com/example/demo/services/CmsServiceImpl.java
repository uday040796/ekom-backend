package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CmsDao;
import com.example.demo.entities.Course;
import com.example.demo.entities.User;


@Service
public class CmsServiceImpl implements CmsService{
	
	@Autowired
	private CmsDao cmsDao;
	
	public CmsServiceImpl() {

	}

	@Override
	public List<Course> getCourses() {
		return this.cmsDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		return this.cmsDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		this.cmsDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		this.cmsDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
	Course entity = this.cmsDao.getOne(parseLong);
	this.cmsDao.delete(entity);
	}
}

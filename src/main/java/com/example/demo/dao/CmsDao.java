package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Course;

public interface CmsDao extends JpaRepository<Course, Long>{

}

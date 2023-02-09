package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM user u WHERE u.email = :email")
	User findByEmail(String email);

}

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;

public interface UserLoginDao extends JpaRepository<UserLogin, Long>{

}

package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;

public interface UserService {
	
	//public static String registerResponse = "";
	public String getRegisterResponse();
	public List<User> getUsers();
	public User getUser(long userId);
	//public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(long parseLong);
	
	public String addUser(User user);
	public String loginUser(UserLogin userLogin);
}

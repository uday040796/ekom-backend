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

import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;
import com.example.demo.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 
  
  @GetMapping("/users")
  public List<User> getUsers(){
	return this.userService.getUsers();
  }
  
 
  @GetMapping("/users/{userId}")
  public User getUser(@PathVariable String userId){
	return this.userService.getUser(Long.parseLong(userId));
  }
  
 
//  @PostMapping("/users")
//  public User addUser(@RequestBody User user){
//	return this.userService.addUser(user);
//  }
  
  @PostMapping("/register")
  public String addUser(@RequestBody User user){
	return this.userService.addUser(user);
  }
  
  @PostMapping("/login")
  public String loginUser(@RequestBody UserLogin userLogin){
	return this.userService.loginUser(userLogin);
  }
  
  
  @PutMapping("/users")
  public User updateUser(@RequestBody User user){
	return this.userService.updateUser(user);
  }
  
 
  @DeleteMapping("/users/{userId}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
	  try {
		  this.userService.deleteUser(Long.parseLong(userId));
		  return new ResponseEntity<>(HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  
  
}

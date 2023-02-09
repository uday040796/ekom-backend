package com.example.demo.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CmsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	String registerResponseInitial;
	String loginResponseInitial;
	List<User> person;
	public UserServiceImpl() {

	}

	@Override
	public List<User> getUsers() {
		return this.userDao.findAll();
	}

	@Override
	public User getUser(long userId) {
		return this.userDao.getOne(userId);
	}

//	@Override
//	public User addUser(User user) {
//		this.userDao.save(user);
//		return user;
//	}
	
	@Override
	public String addUser(User user) {
		int count=0;
		List<User> list = getUsers();
		for(User person:list) {
			if(person.getId()==user.getId()) {
				count++;
			}
		};
		if(count==0) {
			this.userDao.save(user);
			registerResponseInitial = "yes";
		}else {
			registerResponseInitial = "no";
		}
		return registerResponseInitial;
	}

	@Override
	public User updateUser(User user) {
		this.userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(long parseLong) {
		User entity = this.userDao.getOne(parseLong);
	this.userDao.delete(entity);
	}

	@Override
	public String getRegisterResponse() {
		
		return registerResponseInitial;
	}

	@Override
	public String loginUser(UserLogin userLogin) {
		int count = 0;
		String pass = "";
		String email= "";
		List<User> usersAll = getUsers();
		User user = this.userDao.findByEmail(userLogin.getEmail());
		String res= "";
		if(user != null) {
			 if(user.getPassword().equals(userLogin.getPassword())) {
				res= "Login successed";
			 }
			 else {
				 res= "Invalid Password";
			 }
		}else {
			res= "No Accounf Found";
		}
		return res;
//		for(User person:usersAll) {
//			if(person.getEmail().equals(userLogin.getEmail())) {
//				pass = person.getPassword();
//				email = person.getEmail();
//				count++;
//			}
//		}
//		System.out.println(count);
//		if(count >0) {
//			loginResponseInitial = "login now";
//		}else if(count == 0) {
//			loginResponseInitial = "no account";
//		}
//		return loginResponseInitial;
	}

}

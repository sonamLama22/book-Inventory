package com.bfs45.bookmanagement.service;

import java.util.Random;

import com.bfs45.bookmanagement.dao.UserDao;
import com.bfs45.bookmanagement.model.User;

public class UserRegistryService {

	// create a userId by taking user object as an argument.
	public String userCreation(User user) {
		UserDao userDao = new UserDao();
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		user.setUserId(user.getUsername()+"_"+randomNum);
		
		return userDao.saveUser(user);
		
	}
}

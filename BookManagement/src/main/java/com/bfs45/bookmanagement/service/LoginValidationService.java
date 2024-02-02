package com.bfs45.bookmanagement.service;

import com.bfs45.bookmanagement.dao.UserDao;
import com.bfs45.bookmanagement.model.User;

public class LoginValidationService {
	
	public String isValid(User user) {
		
		UserDao userDao = new UserDao();
		String role =  userDao.validateUser(user);
		return role;
	}

}

package com.bfs45.bookmanagement.service;

import com.bfs45.bookmanagement.dao.UserDao;
import com.bfs45.bookmanagement.model.User;

public class LoginValidationService {
	
	public String isValid(User user)  {
	
//		if((user.getUserId() != null || !user.getUserId().isEmpty() )
//				|| user.getPassword()!=null || !user.getPassword().isEmpty()) {
//			UserDao userDao = new UserDao();
//			String role =  userDao.validateUser(user);
//			return role;
//		}else {
//			throw new Exception("login error.");
//		}
		UserDao userDao = new UserDao();
		String role =  userDao.validateUser(user);
		return role;
		
	}

}

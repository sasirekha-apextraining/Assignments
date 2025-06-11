package com.learn.service;

import com.learn.bean.User;
import com.learn.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	@Autowired
	private UserDAO userDao;
	
	public void saveUserInfo(User user) {
		
		userDao.saveUserInfo(user);
	}

}

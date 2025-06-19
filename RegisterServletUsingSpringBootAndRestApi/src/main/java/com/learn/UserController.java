package com.learn;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.user.bean.User;
import com.learn.user.dao.UserDAO;

@RestController
public class UserController {

	User user;
	UserDAO userDAO = new UserDAO();
	
	@PostMapping("/submit")
	public String saveUserDetails(@RequestBody User user) {
		this.user = user;
		userDAO.saveUserInfo(user);
		return "Success";
	}

}

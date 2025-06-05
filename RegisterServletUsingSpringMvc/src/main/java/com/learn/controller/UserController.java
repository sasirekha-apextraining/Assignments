package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learn.bean.User;
import com.learn.dao.UserDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/personal")
	public ModelAndView personalInfo() {
		return new ModelAndView("personalInfo");
	}

	@PostMapping("/contactInfo")
	public ModelAndView contactInfo(HttpServletRequest request, HttpSession session) {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setGender(request.getParameter("gender"));
		session.setAttribute("user", user);

		return new ModelAndView("contactInfo");
	}

	@PostMapping("/bankInfo")
	public ModelAndView bankInfo(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setAddress(request.getParameter("address"));
		user.setCity(request.getParameter("city"));
		user.setState(request.getParameter("state"));
		user.setCountry(request.getParameter("country"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		session.setAttribute("user", user);
		return new ModelAndView("bankInfo");
	}

	@PostMapping("/submit")
	public ModelAndView submit(HttpServletRequest request, HttpSession session) {

		User user = (User) session.getAttribute("user");
        user.setBankName(request.getParameter("bankName"));
        user.setAccountNumber(request.getParameter("accountNumber"));
        user.setSsn(request.getParameter("ssn"));
        userDAO.saveUserInfo(user);
        session.invalidate();
		return new ModelAndView("success");
	}

}

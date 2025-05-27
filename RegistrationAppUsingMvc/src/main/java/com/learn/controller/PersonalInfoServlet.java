package com.learn.controller;

import java.io.IOException;

import com.learn.bean.PersonalInfo;
import com.learn.util.RegisterUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/personalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Validate the User data
		String error = RegisterUtil.validatePersonalInfoRequest(request);
		HttpSession session = request.getSession();

		if (error == null) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String middleName = request.getParameter("middleName");
			String gender = request.getParameter("gender");

			PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, middleName, gender);
			System.out.println(personalInfo.toString());
			session.setAttribute("personalInfo", personalInfo);

			// 3. Load the correct View
			response.sendRedirect("contactInfo.html");
		} else {
			// 3. Load the correct View for error scenarios
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("personalInfo.html");
			requestDispatcher.forward(request, response);

		}

	}

}

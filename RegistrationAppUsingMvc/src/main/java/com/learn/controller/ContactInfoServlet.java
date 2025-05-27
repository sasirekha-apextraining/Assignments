package com.learn.controller;

import java.io.IOException;

import com.learn.bean.ContactInfo;
import com.learn.util.RegisterUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactInfoServlet
 */
@WebServlet("/contactInfoServlet")
public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Validate the User data
		String error = RegisterUtil.validateContactInfoRequest(request);
		HttpSession session = request.getSession();

		if (error == null) {

			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String phoneNumber = request.getParameter("phoneNumber");

			ContactInfo contactInfo = new ContactInfo(address, city, state, country, phoneNumber);
			System.out.println(contactInfo.toString());
			session.setAttribute("contactInfo", contactInfo);

			// 3. Load the correct View
			response.sendRedirect("bankInfo.html");
		} else {
			// 3. Load the correct View for error scenarios
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactInfo.html");
			requestDispatcher.forward(request, response);

		}

	}

}

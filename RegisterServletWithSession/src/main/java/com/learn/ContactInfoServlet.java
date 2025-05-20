package com.learn;

import java.io.IOException;
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
		HttpSession session = request.getSession();
		session.setAttribute("firstName", request.getParameter("firstName"));
		session.setAttribute("lastName", request.getParameter("lastName"));
		session.setAttribute("middleName", request.getParameter("middleName"));
		session.setAttribute("gender", request.getParameter("gender"));
		response.sendRedirect("contactInfo.html");
		
	}

}

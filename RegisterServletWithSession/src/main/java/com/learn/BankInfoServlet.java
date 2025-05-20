package com.learn;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BankInfoServlet
 */
@WebServlet("/bankInfoServlet")
public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("address", request.getParameter("address"));
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("state", request.getParameter("state"));
		session.setAttribute("country", request.getParameter("country"));
		session.setAttribute("phoneNumber", request.getParameter("phoneNumber"));

		response.sendRedirect("bankInfo.html");

	}

}

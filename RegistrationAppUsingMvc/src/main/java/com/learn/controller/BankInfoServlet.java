package com.learn.controller;

import java.io.IOException;

import com.learn.bean.BankInfo;
import com.learn.util.RegisterUtil;

import jakarta.servlet.RequestDispatcher;
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

		String error = RegisterUtil.validateBankInfoRequest(request);
		HttpSession session = request.getSession();

		if (error == null) {

			String bankName = request.getParameter("bankName");
			String accountNumber = request.getParameter("accountNumber");
			String ssn = request.getParameter("ssn");
			BankInfo bankInfo = new BankInfo(bankName, accountNumber, ssn);
			session.setAttribute("bankInfo", bankInfo);

			// 3. Load the correct View
			// redirect to registerUserServlet
			response.sendRedirect("http://localhost:8080/RegistrationAppUsingMvc/registerUserServlet");

		} else {
			// 3. Load the correct View for error scenarios
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankInfo.html");
			requestDispatcher.forward(request, response);

		}

	}

}

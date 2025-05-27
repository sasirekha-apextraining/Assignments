package com.learn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learn.bean.BankInfo;
import com.learn.bean.ContactInfo;
import com.learn.bean.PersonalInfo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Register JDBC Driver
		try {
			// Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			String connectionURL = config.getServletContext().getInitParameter("connectionURL");
			String userName = config.getServletContext().getInitParameter("userName");
			String password = config.getServletContext().getInitParameter("password");

			// Create Connection Object
			connection = DriverManager.getConnection(connectionURL, userName, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html");
		// Collect data
		// need to get all info from session
		PersonalInfo userPersonalInfo = (PersonalInfo) session.getAttribute("personalInfo");
		ContactInfo userContactInfo = (ContactInfo) session.getAttribute("contactInfo");
		BankInfo userBankInfo = (BankInfo) session.getAttribute("bankInfo");

		try {

			String sql = "INSERT INTO UserRegistration (firstname, lastname, middlename, gender, address, city, state, country, phone, bankname, accountnumber, ssn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userPersonalInfo.getFirstName());
			stmt.setString(2, userPersonalInfo.getLastName());
			stmt.setString(3, userPersonalInfo.getMiddleName());
			stmt.setString(4, userPersonalInfo.getGender());
			stmt.setString(5, userContactInfo.getAddress());
			stmt.setString(6, userContactInfo.getCity());
			stmt.setString(7, userContactInfo.getState());
			stmt.setString(8, userContactInfo.getCountry());
			stmt.setString(9, userContactInfo.getPhoneNumber());
			stmt.setString(10, userBankInfo.getBankName());
			stmt.setString(11, userBankInfo.getAccountNumber());
			stmt.setString(12, userBankInfo.getSsn());

			stmt.executeUpdate();

			response.sendRedirect("success.html");

			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error occurred during registration.");
		}

	}

}

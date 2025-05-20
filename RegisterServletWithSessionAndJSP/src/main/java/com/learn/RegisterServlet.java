package com.learn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		String middleName = (String) session.getAttribute("middleName");
		String gender = (String) session.getAttribute("gender");

		String address = (String) session.getAttribute("address");
		String city = (String) session.getAttribute("city");
		String state = (String) session.getAttribute("state");
		String country = (String) session.getAttribute("country");
		String phoneNumber = (String) session.getAttribute("phoneNumber");

		String bankName = request.getParameter("bankName");
		String accountNumber = request.getParameter("accountNumber");
		String ssn = request.getParameter("ssn");

		try {

			String sql = "INSERT INTO UserRegistration (firstname, lastname, middlename, gender, address, city, state, country, phone, bankname, accountnumber, ssn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, middleName);
			stmt.setString(4, gender);
			stmt.setString(5, address);
			stmt.setString(6, city);
			stmt.setString(7, state);
			stmt.setString(8, country);
			stmt.setString(9, phoneNumber);
			stmt.setString(10, bankName);
			stmt.setString(11, accountNumber);
			stmt.setString(12, ssn);

			stmt.executeUpdate();

			response.getWriter().println("Registration Successful!");

			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error occurred during registration.");
		}

	}

}

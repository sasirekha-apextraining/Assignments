package com.learn.util;

import jakarta.servlet.http.HttpServletRequest;

public class RegisterUtil {
	public static String validatePersonalInfoRequest(HttpServletRequest request) {
		String error = null;

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");

		if (firstName.isBlank() || lastName.isBlank() || gender.isBlank()) {
			error = "firstName, lastName or gender should not be empty or blank";
		}

		return error;
	}

	public static String validateContactInfoRequest(HttpServletRequest request) {
		String error = null;

		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phoneNumber = request.getParameter("phoneNumber");

		if (address.isBlank() || city.isBlank() || state.isBlank() || country.isBlank() || phoneNumber.isBlank()) {
			error = "address, city, state, country or phoneNumber should not be empty or blank";
		}

		return error;
	}

	public static String validateBankInfoRequest(HttpServletRequest request) {
		String error = null;

		String bankName = request.getParameter("bankName");
		String accountNumber = request.getParameter("accountNumber");
		String ssn = request.getParameter("ssn");

		if (bankName.isBlank() || accountNumber.isBlank() || ssn.isBlank()) {
			error = "bankName, accountNumber or ssn should not be empty or blank";
		}
		System.out.println("error from validateBankInfoRequest --- "+error);
		return error;
	}

}

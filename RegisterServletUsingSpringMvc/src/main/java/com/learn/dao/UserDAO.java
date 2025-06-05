package com.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.bean.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveUserInfo(User user) {
		String sql = "INSERT INTO UserRegistration (firstname, lastname, middlename, gender, address, city, state, country, phone, bankname, accountnumber, ssn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getMiddleName(), user.getGender(),
				user.getAddress(), user.getCity(), user.getState(), user.getCountry(), user.getPhoneNumber(),
				user.getBankName(), user.getAccountNumber(), user.getSsn());
	}

}

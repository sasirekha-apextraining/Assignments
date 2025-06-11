package com.learn.user.client;

import com.learn.user.bean.User;
import com.learn.user.dao.UserDAO;

public class UserClient 
{
    public static void main( String[] args )
    {
    	
    	UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setFirstName("acs");
		user.setLastName("acs");
		user.setMiddleName("acs");
		user.setGender("Male");
		user.setAddress("CA");
		user.setCity("ca");
		user.setState("ca");
		user.setCountry("USA");
		user.setPhoneNumber("12342323");
		user.setBankName("Bofa");
		user.setAccountNumber("222223232");
		user.setSsn("1111132323	");
		userDAO.saveUserInfo(user);
    }
}

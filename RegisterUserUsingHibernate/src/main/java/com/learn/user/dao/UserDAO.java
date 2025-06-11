package com.learn.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.user.util.HibernateUtil;
import com.learn.user.bean.User;

public class UserDAO {
	
	public void saveUserInfo(User user) {
		
		Session ses =  HibernateUtil.getSessionFactory().openSession();
		  Transaction tx = ses.beginTransaction();
		  ses.save(user);
		  tx.commit();
	}

}

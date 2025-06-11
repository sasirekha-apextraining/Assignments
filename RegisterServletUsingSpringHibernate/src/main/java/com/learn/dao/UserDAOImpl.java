package com.learn.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bean.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public void saveUserInfo(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}

package com.bo.impl;

import java.util.List;

import com.bo.UserBO;
import com.dao.UserDao;
import com.model.User;

/**
 * A class implementing UserBO Interface to override required functions
 *
 */
public class UserBoImpl implements UserBO{
	
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String save(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public String updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	

}

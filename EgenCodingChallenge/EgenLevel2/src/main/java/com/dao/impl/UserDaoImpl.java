package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.model.User;

/**
 * Implementation Dao class, that uses HibernateDaoSupport configured by Hibernate.xml
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public String save(User user) {//called by createUser service
		try{
			getHibernateTemplate().saveOrUpdate(user);
		}
		catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}

	@Override
	public List<User> getAllUsers() {//called by Find User Service
		System.out.println("In the Dao Layer");
		
		List<User> userList = new ArrayList<User>();
		try{
			userList = getHibernateTemplate().find("from User");
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	@Override
	public String updateUser(User user) {//called by Update user service
		try{
			getHibernateTemplate().update(user);
		}
		catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}

	
}

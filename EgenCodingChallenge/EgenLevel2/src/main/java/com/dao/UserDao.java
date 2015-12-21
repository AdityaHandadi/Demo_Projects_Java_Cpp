package com.dao;

import java.util.List;

import com.model.User;

/**
 * Interface for Dao operations
 */
public interface UserDao {
	
		public String save(User user);
	
		public List<User> getAllUsers();
		
		public String updateUser(User user);

}

package com.bo;

import java.util.List;

import com.model.User;


/**
 * This is an interface created for all User related Business logic operations
 *
 */
public interface UserBO {
	
	//Creates the User if he is not available in the dataStore
	public String save(User user);
	
	//Gives the list of all users that are in the datastore
	public List<User> getAllUsers();
	
	//Finds the user from the data store, if found updates, else 404
	public String updateUser(User user);
	
	
}

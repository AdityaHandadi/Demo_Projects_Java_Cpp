package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bo.UserBO;
import com.model.User;
import com.view.UserVO;

/**
 * This is the Service Layer, that the Controller calls for all its operations
 * 
 */
public class UserService {
	
	//Initialize the bean factory
	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    UserBO userBO = (UserBO)appContext.getBean("userBo");
	
	/* 
	 * This method creates BO objects compatible with back-end from front-end Views
	 */
	public User createUserBOFromVO(UserVO userVO){
		User user = new User();//BO
		user.setUuid(userVO.getUuid());
		user.setFirstName(userVO.getFirstName());
		user.setMiddleName(userVO.getMiddleName());
		user.setLastName(userVO.getLastName());
		user.setGender(userVO.getGender());
		user.setPhoneNumber(userVO.getPhoneNumber());
		user.setZip(userVO.getZip());
		
		return user;
	}
	
	/* 
	 * This method creates VO objects compatible with front-end from back-end Model
	 */
	public UserVO createUserVOFromBO(User user){
		UserVO userVO = new UserVO();//BO
		userVO.setUuid(user.getUuid());
		userVO.setFirstName(user.getFirstName());
		userVO.setMiddleName(user.getMiddleName());
		userVO.setLastName(user.getLastName());
		userVO.setGender(user.getGender());
		userVO.setPhoneNumber(user.getPhoneNumber());
		userVO.setZip(user.getZip());
		
		return userVO;
	}
	
	//This method uses the autowired userBO to call the Dao Implementation
	public String createUser(UserVO userVO){
		User user = createUserBOFromVO(userVO);
		
		String ret = userBO.save(user);
		
		return ret;
	}

	//Find users from the Dao layers
	public List<UserVO> findUsers(){
		List<User> userList = userBO.getAllUsers();
		List<UserVO> userVOList = new ArrayList<UserVO>();
		
		Iterator<User> userIt = userList.iterator();
		
		while(userIt.hasNext()){
			User user = userIt.next();
			UserVO userVO = createUserVOFromBO(user);
			userVOList.add(userVO);
		}
		
		return userVOList;
	}
	
	//Update Users
	public String updateUser(UserVO userVO){
		User user = createUserBOFromVO(userVO);
		String ret = userBO.updateUser(user);
		
		return ret;
	}
	
}

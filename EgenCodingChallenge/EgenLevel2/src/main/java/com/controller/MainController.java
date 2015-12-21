package com.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.UserService;
import com.view.MyResponse;
import com.view.UserVO;



/**
 * @author adityahandadi
 * This is the entry point when a request is fired appropriately
 * Uses Jersey-Jackson Annotations for Converting Views To JSONs / vice-versa
 *
 */
@Path("/user")
public class MainController {
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MyResponse saveUser(UserVO userVO){ //creates user
		
		MyResponse response  = new MyResponse();
		
		//Check if the user id in the request is appropriate
		if(userVO.getUuid()!= 0){
			if(userVO.getFirstName()!=null){
				System.out.println("Saving data for : "+userVO.getFirstName());
			}
			
			//Call a userService
			UserService userService = new UserService();
			String message = userService.createUser(userVO);
			response.setStatus(200);//if success, set the response code
			response.setMessage(message);
		}
		else{
			String message = "fail";
			response.setStatus(400);//failed response code
			response.setMessage(message);
		}
		
		return response;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public MyResponse getAllUsers(){//find all the created Users
		MyResponse response  = new MyResponse();
		UserService userService = new UserService();
		
		if(userService.findUsers()!=null){
			response.setUserList(userService.findUsers());
			response.setStatus(200);
			response.setMessage("Retrieving all Users");
		}
		else{
			response.setStatus(400);
			response.setMessage("failed");
		}
		
		return response;
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MyResponse updateUser(UserVO userVO){
		MyResponse response  = new MyResponse();
				if(userVO.getUuid()!= 0){
					if(userVO.getFirstName()!=null){
						System.out.println("Updating for UserID: "+userVO.getUuid());
					}
					
					//Create a new instance of Service for User
					UserService userService = new UserService();
					String message = userService.updateUser(userVO);
					if(message == "success"){
						response.setStatus(200);
						response.setMessage(message);
					}
					else if(message == "fail"){
						System.out.println("No Specific Primary Key found");
						throw new javax.ws.rs.WebApplicationException(404);
					}
				}
				else{
					System.out.println("No Primary Key found");
					throw new javax.ws.rs.WebApplicationException(404);
				}
				
				return response;
	}
}

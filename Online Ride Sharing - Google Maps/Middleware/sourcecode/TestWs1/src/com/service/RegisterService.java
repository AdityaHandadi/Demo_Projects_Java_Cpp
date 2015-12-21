package com.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterDao;
import com.model.RegisterVO;

@Path("/regservice")
public class RegisterService {
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveRegisterData(RegisterVO regVO){
		
		RegisterDao registerDao = new RegisterDao();
		
		
		if(regVO!=null){
			System.out.println(regVO.getFname());
			System.out.println(regVO.getLname());
			System.out.println(regVO.getEmail());
			
			String str = registerDao.registerRec(regVO);
			
			return str;
			
		}
		else{
			System.out.println("@RegisterService :No Object recieved from JSON");
			return "fail";
		}
		
		//return "success";
	}

}

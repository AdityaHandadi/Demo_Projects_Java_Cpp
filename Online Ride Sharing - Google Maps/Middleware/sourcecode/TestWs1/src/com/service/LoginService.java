package com.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.dao.LoginDao;
import com.model.LoginVO;

@Path("/loginservice")
public class LoginService {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(LoginVO loginVO){
		String msg ="";
		
		if(loginVO!=null){
			System.out.println(loginVO.getLoginId() +" " +loginVO.getPassword());
		
		/*if(loginVO.getLoginId().equals("abc") && loginVO.getPassword().equals("123"))
		  return "success";
		else
			return "fail"; */
			LoginDao loginDao = new LoginDao();
			msg = loginDao.loginCheck(loginVO);
		}
		
		return msg;
		
	}
	
	@POST
	@Path("/admin")
	@Consumes(MediaType.APPLICATION_JSON)
	public String admin(LoginVO loginVO){
		String msg ="";
		
		if(loginVO!=null){
			System.out.println(loginVO.getLoginId() +" " +loginVO.getPassword());
		
		/*if(loginVO.getLoginId().equals("abc") && loginVO.getPassword().equals("123"))
		  return "success";
		else
			return "fail"; */
			LoginDao loginDao = new LoginDao();
			msg = loginDao.adminCheck(loginVO);
		}
		
		return msg;
	
	}
}

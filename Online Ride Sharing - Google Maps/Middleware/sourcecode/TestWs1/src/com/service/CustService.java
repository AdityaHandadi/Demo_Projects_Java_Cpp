package com.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CustDao;
import com.model.CustVO;
import com.model.EmailData;
import com.model.NotifyVO;

@Path("/custservice")
public class CustService {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public String custRegister(CustVO custVO){
		
		CustDao custDao = new CustDao();
		String msg = "";
		
		if(custVO!=null && custVO.getEmail()!=null){
			msg = custDao.saveCust(custVO);
		}
		
		return msg;
	}
	
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustVO> getCusts(EmailData emaildata){
		CustDao custDao = new CustDao();
		
		return custDao.getSpecificRider(emaildata.getEmail());
	}
	
	@POST
	@Path("/book")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String advancebook(CustVO custVO){
		
		CustDao custDao = new CustDao();
		String msg = "";
		
		if(custVO!=null && custVO.getEmail()!=null){
			msg = custDao.advanceBook(custVO);
		}
		
		return msg;
	}
	
	@POST
	@Path("/notify")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmailData> notify(NotifyVO notify){
		CustDao custDao = new CustDao();
		
		if(notify!=null){
			return custDao.notifyEmails(notify);
		}
		
		return null;
	}
	
}

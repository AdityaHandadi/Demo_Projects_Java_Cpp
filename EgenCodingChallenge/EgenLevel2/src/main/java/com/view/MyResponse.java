package com.view;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This is the Common Response class, which is used to send Response JSON to client
 *
 */
@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class MyResponse{
	
	private int status;
	private String message;
	private List<UserVO> userList;
	private Exception ex;
	
	public MyResponse() {
		super();
	}
	
	public MyResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	public List<UserVO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}
	
	
	
}

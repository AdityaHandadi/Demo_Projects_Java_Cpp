package com.model;

public class RegisterVO {
	
	private String fname;
	private String lname;
	private String password;
	private String email;
	private String userType;
	
	
	
	public RegisterVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RegisterVO(String fname, String lname, String password,
			String email, String userType) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
	

}

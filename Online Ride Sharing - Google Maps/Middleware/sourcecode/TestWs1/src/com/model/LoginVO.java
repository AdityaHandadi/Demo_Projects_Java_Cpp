package com.model;

public class LoginVO {
	private String loginId;
	private String password;
	
	public LoginVO(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.classes;

public class CustomerInfo {
	
	private int custId;
	private String firstName;
	private String lastName;
	private String mailingAddress;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String mobNum;
	
	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public CustomerInfo(int custId, String firstName, String lastName,
			String mailingAddress, String country, String state, String city,
			String zipCode, String mobNum) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailingAddress = mailingAddress;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.mobNum = mobNum;
	}



	public CustomerInfo(int custId, String firstName, String lastName,
			String mailingAddress, String country, String state, String city) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailingAddress = mailingAddress;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = "000000";
		this.mobNum = "0000000000";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	
	
	
	
	
}

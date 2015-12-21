package com.view;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * A view object to convert JSON to Java readable POJO
 */
@XmlRootElement
public class UserVO {
	
	private int uuid;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private char gender;
	private long phoneNumber;
	private String zip;
	
	public UserVO() {
		super();
		
	}
	public UserVO(int uuid, String firstName, String middleName,
			String lastName, int age, char gender, long phoneNumber, String zip) {
		super();
		this.uuid = uuid;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}

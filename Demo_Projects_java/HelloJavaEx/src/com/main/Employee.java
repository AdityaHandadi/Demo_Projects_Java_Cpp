package com.main;

public class Employee {

	String name;
	Integer id;
	String address;
	String number;
	
	
	public Employee() {
		super();
		this.name = "Aditya";
		this.id = 123;
		this.address = "1901 Live Oak Street";
		this.number = "229-123-5489";
	}


	public Employee(String name, Integer id, String address, String number) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.number = number;
	}
	
	
	
}

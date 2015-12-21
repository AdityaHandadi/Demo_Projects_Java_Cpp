package com.main;

public class Student {
	
	private final int id;
	private static String name;
	private String someVar;
	
	public Student(int id, String someVar) {
		super();
		this.id = id;
		this.someVar = someVar;
		this.name = someVar;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", someVar=" + someVar +" name="+name + "]";
	}



	public static String getName() {
		return name;
	}



	public static void setName(String name) {
		Student.name = name;
	}



	public String getSomeVar() {
		return someVar;
	}



	public void setSomeVar(String someVar) {
		this.someVar = someVar;
	}



	public int getId() {
		return id;
	}
	
	
	
}

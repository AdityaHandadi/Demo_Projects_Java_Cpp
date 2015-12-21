package com.main;

import com.model.Student;

public class Main {
	
	public static Student setStudent(int id,String name){
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		
		//student.name = name gives compilation error
		
		return student;
	}

	public static void printStudent(Student student){
		
		//System.out.println("ID: "+student.id+" Name : "+student.name);
		System.out.println("ID: "+student.getId()+" Name: "+student.getName());
		
	}
	
	public static void main(String args[]){
		Student student1 = setStudent(1,"abc");
		
		Student student = new Student();
		student.setId(10);
		student.setName("ABC");
		
		Student student2 = setStudent(2,"def");
		Student student3 = setStudent(3,"fgh");
		
		printStudent(student1);
		printStudent(student2);
		printStudent(student3);
		
		System.out.println(student.getId()+" "+student.getName());
	}
}

package com.main;

public class Main {
	
	public static void main(String args[]){
		Func func = new Func();
		System.out.println(func.fun(2));
		
		int a = 255;
		int b = 100;
		System.out.println("1:"+Math.abs(a-b)+"|2:"+Math.abs(b-a));
		
		Student stu1 = new Student(1, "Hello");
		Student stu2 = new Student(2, "Welcome");
		
		System.out.println(Student.getName());
		System.out.println(Student.getName());
		
		
	}

}

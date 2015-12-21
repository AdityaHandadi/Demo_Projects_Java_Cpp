package com.main;

import com.classes.BasicFuncs;
import com.classes.Student;
import com.classes.Triangle;

public class Main_ {
	
	public static void main(String args[]) {
		BasicFuncs basicFuncs = new BasicFuncs();
		
		System.out.println("Average: "+basicFuncs.average(4, 6, 7));
		System.out.println("Simple Interest: "+ basicFuncs.simpleInterest(10000, 2, 2));
		System.out.println("Celcius to Farhen : "+basicFuncs.celciusToFarhn(45.6f));
		System.out.println("ASCII: "+ basicFuncs.returnAscii('a'));
		System.out.println("Power and Base : "+basicFuncs.calPower(10, 2));
		
		Student student = new Student();
		student.setSub1_marks(10.0f);
		student.setSub2_marks(20.0f);
		student.setSub3_marks(30.0f);
		student.setSub4_marks(40.0f);
		student.setSub5_marks(50.0f);
		System.out.println("Student total: "+basicFuncs.studentTotal(student));
		
		System.out.println("Student Calculator: "+basicFuncs.calculator(10, 5, '/'));
		
		Triangle triangle = new Triangle();
		
		triangle.setBase(4.0f);
		triangle.setHeight(5.0f);
		basicFuncs.calculateTriangle(triangle);
		System.out.println("Triangle Hypotenuse: "+triangle.getHypotenuse());
		System.out.println("Triangle Area:" + triangle.getArea());
		
		
		
		
	}
}

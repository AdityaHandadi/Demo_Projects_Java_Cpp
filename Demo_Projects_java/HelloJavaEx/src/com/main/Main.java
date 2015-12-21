package com.main;

import com.cla.Bb;

public class Main {
	int one;
	int two;
	static int m = 7;
	private String name_ = "Aditya";
	private static String str = "staticString";
	
	public Main(){
		super();
	}
	
	public Main(String name_){
		this.name_ = name_;
	}
	
	static {
		System.out.println( "Just printing static");
		
	}
	
	private static void printStaticStrings(){
		System.out.println(str+" ");
		//System.out.println(name_);
	}
	
	
	public static void main(String args[]){
		Main main_ = new Main();
		main_.one = 1;
		main_.two = 2;
		System.out.println(main_.one+" "+main_.two);
		System.out.println(m);
		
		T1 t1 = new T1();
		t1.printStatic();
		
		//Constructor tutorial
		/* Employee emp1,emp2,emp3;
		emp1  = new Employee();
		emp2 = new Employee("ABC",12,"some address","2345");
		emp3 = new Employee("DEF",24,"some address","8979");
		
		System.out.println("EMP1:" + emp1.address);
		System.out.println("EMP2:" + emp2.name);
		System.out.println("EMP3:"+ emp3.number); */
		
		Bb bb = new Bb();
		bb.print();
		
		//Aa aa
		Main.printStaticStrings();
		Main main2 = new Main("ABC");
		
		//String str_new = new String("Hello");
		//str_new = "New";
		//String str_old = "Hello";
		//String str_old2 = "Hello";
		String str_old = new String("Hello");
		String str_old2 = str_old;
		//String str_old2 = new String("Hello");
		System.out.println(str_old2.equals(str_old)); // checks actual contents
		System.out.println(str_old == str_old2); // checks memory locations
		
	}
		
}


class T1{
	 void printStatic(){
		System.out.println(Main.m);
	}
}

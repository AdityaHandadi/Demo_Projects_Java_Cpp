package com.main;

public class Main {

	public static void main(String args[]){
		String a = "hello";
		String c = "Hello";
		String b = new String("hello");
		String e = new String("hello");
		String d = "hello";
		
		if(a==d)
			System.out.println("equal");
		else
			System.out.println("NE");
		if(a.equals(b)){
			System.out.println("equal");
		}	
		
	}
}

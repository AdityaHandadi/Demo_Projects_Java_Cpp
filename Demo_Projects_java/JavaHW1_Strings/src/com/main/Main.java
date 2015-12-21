package com.main;

import com.classes.EmailManipulator;

public class Main {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		EmailManipulator emailMan =  new EmailManipulator("Sachin Tendulkar","sachin@abc.com");
		
		emailMan.addNametoEmail();
		System.out.println(emailMan.addNametoEmail());
		
		System.out.println(emailMan.extractStringBeforeAt());
		
		System.out.println(emailMan.insertMidName("Ramesh"));
		
		System.out.println(emailMan.removeMidName("Ramesh"));
		
		System.out.println(emailMan.replaceName("Virat Kohli"));
	}
}

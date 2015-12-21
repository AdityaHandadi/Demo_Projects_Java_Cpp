package com.classes;

public class Security {
	
	private String name;
	private int hours;
	private double rateOfWages;
	private double wages;
	
	//get
	public Security(String name, int hours, double rateOfWages, double wages) {
		super();
		this.name = name;
		this.hours = hours;
		this.rateOfWages = rateOfWages;
		this.wages = wages;
	}
	
	public void get(){
		
	}
	
	public void calWage(){
			if(hours <= 40)
				wages = 50.0 * hours;
			else if(hours > 40 && hours <= 60)
				wages = 2000 + (hours-40)*30;
			else if(hours > 60 && hours <= 70)
				wages = 2000 + 600 + (hours - 60)*25;
			else
				wages = 0.0;
	}
	
	public void display(){
		
		System.out.println("---Name-------Hours----Wage----");
		System.out.println("-- "+name+" ---"+hours+"---"+wages);
		
	}

}

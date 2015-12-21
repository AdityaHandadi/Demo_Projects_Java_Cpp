package com.cla;

public class Bb {
	
	public int first = 1;
	public int second = 2;
	
	public void print(){
		Aa aa = new Aa();
		
		aa.print(); //default modifier
		System.out.println(aa.two);
		System.out.println(aa.three);
		
	}
	
}

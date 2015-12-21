package com.main;


public class MidTermMain {
	
	public static void main(String args[]){
		double[] elements = {-10, -9.5, -9.0,-0.5, 0.0, 0.5, 9.0, 9.5, 10};
		double[] output = new double[elements.length];
		LinearFunction lf = new LinearFunction(3, -1);
		System.out.println(lf);
		int idx = 0;
		for(double d:elements){
			output[idx++]=lf.evaluate(d);
		}
		
		for(double d:output){
			System.out.println(d);
		}
	}

}

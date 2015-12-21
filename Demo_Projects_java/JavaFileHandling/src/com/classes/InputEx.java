package com.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputEx {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter First Num :");
		int num1 = br.read();
		
		System.out.println("Entered Number is :"+num1);
		//float RealNumber = 3.11;
	
	}
}

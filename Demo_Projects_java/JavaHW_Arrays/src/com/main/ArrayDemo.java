package com.main;

import com.classes.ArrayJava;

public class ArrayDemo {
	
	static int arr[] = {1,2,3,4,5,6,7,8,9,10};
	static char arr_2[] = {'a','d','i','t','y','a'};
 	
	public static void main(String args[]){
		
		ArrayJava arrayObj = new ArrayJava();
		
		arrayObj.printArray(arr);
		System.out.println(arrayObj.calculateSum(arr));
		System.out.println(arrayObj.calculateEvenSum(arr));
		arrayObj.printArray(arrayObj.replaceOddByOne(arr));
		System.out.println(arrayObj.vowelInArray(arr_2));
		
	}
}


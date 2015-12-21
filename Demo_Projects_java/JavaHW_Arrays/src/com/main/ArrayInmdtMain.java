package com.main;

import com.classes.ArrayInmdt;

public class ArrayInmdtMain {

	static int arr[] = {1,2,3,4,5,6,7,8,9,10};
	static int arr_b[] = {7,3,9,1,4,2,3,6,5,8};
	static int a[][] = {{1,2,3},{4,5,6}};
	static int b[][] = {{1,1,1},{1,1,1}};
	
	public static void main(String args[]){
		ArrayInmdt arrayFnc = new ArrayInmdt();
		//a
		int idx = arrayFnc.srchArray(arr, 9);
		if(idx != -1){
			System.out.println("Element found in index :" + idx);
		}
		else{
			System.out.println("Element not found ");
		}
		
		//b
		int sort[] = arrayFnc.sortArray(arr);
		System.out.println("Sorting:");
		for(int i=0;i<sort.length;i++)
			System.out.print(sort[i]+" ");
		System.out.println();
		
		//c
		System.out.println("Display Array:");
		arrayFnc.display2darray(a);
		
		//d
		int d[][] = arrayFnc.transposeArray(a);
		System.out.println("Transpose:");
		arrayFnc.display2darray(d);
		//System.out.println();
		
		//e
		int e[][] = arrayFnc.add2dArray(a, b);
		System.out.println("Addition:");
		arrayFnc.display2darray(e);
		
	}
}

package com.main;

import java.util.ArrayList;
import java.util.List;

public class MyArrays {

	public static void main(String args[]){
		double[] myDouble = {2.3,4.5,6.5,4.45,6.23};
		
		System.out.println("Length myDouble : "+myDouble.length);
		
		List<Double> myDouble2 = new ArrayList<Double>();
		myDouble2.add(2.3);
		myDouble2.add(3.3);
		myDouble2.add(4.4);
		myDouble2.add(5.3);
		myDouble2.add(6.23);
		
		System.out.println("Size myDouble2 : "+myDouble2.size());
		
		double temp;
		 int j;
		 for(int i=1;i< myDouble.length-1 ;i++){
			 temp = myDouble[i];
			 j = i ;
			 while(j>0 && myDouble[j-1]>temp){
				 myDouble[j] = myDouble[j-1];
				 
			 }
			 myDouble[j] = temp;
		 }
			
		 for(Double doub:myDouble){
			 System.out.print( doub +" ");
		 }
		
	}
	
}

package com.main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
    	int temp1;
    	for(int i=ar.length-1; i>0 ; i--){
    		temp1 = ar[i];
    		int j;
    		for(j=i; j>=0 ;j--){
        		if(j>0 && ar[j-1] > temp1){
        			ar[j] = ar[j-1];
        		}
        		else{
        			ar[j] = temp1;
        			break;
        		}
        		printArray(ar);
    		}
    	}
    	printArray(ar);
    }
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
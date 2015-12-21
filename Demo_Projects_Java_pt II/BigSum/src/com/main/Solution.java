package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Long Integers Multiplication..
public class Solution {
	
	static int maxN = 10;

    public static void main(String[] args) throws IOException{
        
    	
    	long sum = 0L;
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	int n = 5;
    	
    	//String[] splited ;
    	if(str!=null){
    		String[] splited = str.split("\\s+");
    	
    	
	    	for(int i=0;i<n ;i++){
	    		long x = Long.valueOf(splited[i]).longValue();
	    		sum += x;
	    	}
	    
	    }
    	System.out.println(sum);
    	
    	
    }
}

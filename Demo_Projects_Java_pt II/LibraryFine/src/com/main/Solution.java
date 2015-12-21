package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
	
	 public static void main(String[] args) throws IOException {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	
		 //String date1 = br.readLine();
		 String[] date1 = br.readLine().split("\\s+");
		 String[] date2 = br.readLine().split("\\s+");
		 
		 Calendar date1_c = new GregorianCalendar(Integer.valueOf(date1[2]),Integer.valueOf(date1[1])-1,Integer.valueOf(date1[0]));
		 Calendar date2_c = new GregorianCalendar(Integer.valueOf(date2[2]),Integer.valueOf(date2[1])-1,Integer.valueOf(date2[0]));
		 
		 //System.out.println(date1_c.get(Calendar.DAY_OF_MONTH));
		 //System.out.println(date2_c.get(Calendar.DAY_OF_MONTH));
		 int totalFine = 0;
		 int d1_Y = date1_c.get(Calendar.YEAR);
		 int d2_Y = date2_c.get(Calendar.YEAR);
		 
		 int d1_M = date1_c.get(Calendar.MONTH);
		 int d2_M = date2_c.get(Calendar.MONTH);
		 
		 int d1_D = date1_c.get(Calendar.DAY_OF_MONTH);
		 int d2_D = date2_c.get(Calendar.DAY_OF_MONTH);
		 
		 //System.out.println(d1_Y +" "+ d2_Y);
		 
		 if(d1_Y > d2_Y){
			 System.out.println(10000);
		 }
		 else if(d1_Y == d2_Y && d1_M  > d2_M ){
			 int diff = d1_M  - d2_M ;
			 int fine = diff* 500;
			 System.out.println(fine);
		 }
		 else if(d1_Y == d2_Y && d1_M == d2_M && d1_D  > d2_D){
			 int diff = d1_D - d2_D;
			 int fine = diff* 15;
			 System.out.println(fine);
		 }
		 else{
			 System.out.println(totalFine);
		 }
		 
		 
		 //Failed Test Case Input
		 //1 1 2015
		 //31 12 2014
		 //OUTPUT
		 //10000
	 }
	 
}

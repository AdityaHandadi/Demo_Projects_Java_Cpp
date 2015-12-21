package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int n = Integer.valueOf(br.readLine());	
	
		for(int i=0; i<n ;i++){
			
			for(int j=i+1; j<n ; j++){
				System.out.print(" ");
			}
			
			for(int x=0; x<=i ; x++){
				System.out.print("#");
			}
			
			System.out.println();
		}
	}
}

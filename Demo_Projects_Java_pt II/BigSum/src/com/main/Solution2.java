package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Differences of the sums of diagonals
public class Solution2 {
	
	static int maxN = 100;

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	int[][] arr = new int[maxN][maxN];
    	
    	for(int i=0;i< n;i++){
    		String str = br.readLine();
    		String[] strsplit = str.split("\\s+");
    		for(int j=0;j<n;j++){
    			arr[i][j] = Integer.valueOf(strsplit[j]);
    		}
    	}
    
    	
    	int j,k;
    	
    	//Debug
    	/* for(int i=0;i< n;i++){
    		for(j=0;j<n ; j++){
    			System.out.print(arr[i][j]+" ");
    		}
    		System.out.println();	
    	} */
    	int sumDiag1 = 0; 
    	int sumDiag2 = 0;
    	
    	for(int i=0;i < n;i++){
    		j=i; k=n-1-i;
    		
    		sumDiag1 += arr[i][j];
    		sumDiag2 += arr[i][k];
    	}
    	int diff = 0;
    	
    	if(sumDiag1 > sumDiag2 )
    		diff = sumDiag1 - sumDiag2;
    	else
    		diff = sumDiag2 - sumDiag1;
    	
    	System.out.println(diff);
    	
    }
}

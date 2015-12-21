package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

	static int maxN = 100;
	public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		String[] strsplit = br.readLine().split("\\s+");
		
		int neg = 0,pos = 0 ,zer = 0;
		
		for(int i=0; i<n ; i++){
			int x = Integer.valueOf(strsplit[i]);
			if(x>0)
				pos++;
			if(x<0)
				neg++;
			if(x == 0)
				zer++;
			
		}
		
		//System.out.println(pos+" "+neg+" "+zer);
		
		double posRes = (double)pos/n;
		double negRes = (double)neg/n;
		double zerRes = (double)zer/n;
		
		//System.out.println(posRes+" "+negRes+" "+zerRes);
		
		
		//posRes = (double) Math.round((posRes * 1000)/1000); //1
		//negRes = (double) Math.round((negRes * 1000)/1000); //0
		//zerRes = (double) Math.round((zerRes * 1000)/1000); //0
		//String.format("%.3g%n", posRes);
		
		System.out.println(String.format("%.3g", posRes));
		System.out.println(String.format("%.3g", negRes));
		System.out.println(String.format("%.3g", zerRes));
	
	}
	
}

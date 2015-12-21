package com.main;

public class Func {

	public int fun(int n){
		if(n==1) return 1;
		int sum = 0;
		for(int i=1;i<n;i++){
			if(i%2 != 0){
				sum = sum + 3*fun(i);
			}
		}
		return sum;
		
	}
}

package com.classes;

public class ArrayJava {

	//a , n natural numbers and print them
	public void printArray(int arr[]){
		for(int i=0; i< arr.length ; i++){
			System.out.print( arr[i] + " ");
		}
		System.out.print("\n");
	}
	
	//b , add all sum
	public int calculateSum(int arr[]){
		int sum = 0;
		for(int i=0; i< arr.length ; i++){
			sum+=arr[i];
		}
		return sum;
	}
	
	//c, add only even
	public int calculateEvenSum(int arr[]){
		int sum = 0;
		for(int i=0; i< arr.length ; i++){
			if(arr[i]%2 == 0)
				sum+=arr[i];
		}
		return sum;
	}
	
	//d, replace odd numbers
	public int[] replaceOddByOne(int arr[]){
		for(int i=0; i< arr.length ; i++){
			if(arr[i]%2 != 0)
				arr[i] = 1;
		}
		return arr;
	}
	
	//e , count vowels
	public int vowelInArray(char arr[]){
		int count = 0;
		for(int i=0; i< arr.length ; i++){
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
				count ++;
			}
		}
		return count;
	}
	
	
}

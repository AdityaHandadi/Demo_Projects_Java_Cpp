package com.classes;

public class ArrayInmdt {

	
	public int srchArray(int arr[],int searchVal){
		for(int i=0; i<arr.length ; i++){
			if(arr[i] == searchVal){
				return i;
			}
		} 
		return -1;
	}
	
	public int[] sortArray(int arr[]){
		//bubble sort
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i] > arr [j])
					swap(arr[i],arr[j]);
			}
			
		}
		return arr;
	}
	
	public void swap(int a,int b){
		int temp = b;
		b = a;
		a = temp;
	}
	
	//c
	public void display2darray(int arr[][]){
		for(int i=0; i<arr.length ; i++){
			for(int j=0; j<arr[i].length ; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//d
	public int[][] transposeArray(int arr[][]){
	
		int c[][] = new int[arr[0].length][arr.length];
		for(int i=0; i<arr.length ; i++){
			for(int j=0; j<arr[i].length ; j++){
				c[j][i] = arr[i][j];
			}
		}
		return c;
	}
	
	//e
    public int[][] add2dArray(int a[][],int b[][]){
    	int c[][] = a;
    	for(int i=0; i<a.length ; i++){
			for(int j=0; j<a[i].length ; j++){
				c[i][j] = a[i][j]+b[i][j];
			}
    	}
    	
    	return c;
    }
}

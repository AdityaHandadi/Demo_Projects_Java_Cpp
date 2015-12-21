package com.main;

import java.util.Scanner;

import com.classes.Functions;

public class Main {
	
	public static void main(String args[]){
		Scanner scanner =  new Scanner(System.in);
		
		System.out.println("Enter n: ");
		
		int n = scanner.nextInt();
		
		System.out.println("Enter the inputs");
		
		int i = 0;
		int j,d = 0;
		
		System.out.println(n);
		
		int a[][]= new int[n+1][n+1];
		
		//populate array with default values
		for(int x=0; x<a.length ; x++){
			for(int y=0; y<a[0].length ; y++){
				if(x!=y)
					a[x][y] = 999;
			}
		}
		
		
		while(true){
			
			i = scanner.nextInt();
			if(i == -1)
				break;
			
			j = scanner.nextInt();
			d = scanner.nextInt();
			
			a[i][j] = d;
			//System.out.println(i + " "+j+" "+k);
		}
		
		Functions func = new Functions();
		func.printArray(a);
		
		System.out.println(" Enter Penalty Matrix ");
		int p[] = new int[n+1];
		int k = 0;
		d = 0;
		
		while(true){
			
			k = scanner.nextInt();
			if(k == -1)
				break;
			d = scanner.nextInt();
			
			p[k] = d;
		}
		
		func.printPenaltyMtx(p);
		
		//func.checkForUNodes(a, n);

		//disable nodes
		System.out.println(" Enter Disable Matrix : -1 to exit ");
		int x[] = new int[n+1];
		int o = 0;
		d = 0;
		
		while(true){
			
			o = scanner.nextInt();
			if(o == -1)
				break;
			//d = scanner.nextInt();
			
			x[o] = 1;
		}
		
		//end of disable
		
		System.out.println("\n After FLoyd's algorithm");
		func.floydsAlgo(a, n , p ,x);
		
		System.out.println(" ");
		func.printArray(a);
		
		
		scanner.close();
		
	}

}

package com.classes;

public class Functions {
	
	public void printArray(int a[][]){
		for(int i=1; i<a.length ; i++){
			for(int j=1; j<a[0].length ; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] floydsAlgo(int a[][],int n,int p[],int x[]){
		int i,j = 1;
		
		for(int k = 1; k <= n ; k++){
			//check for disabled here
			if(x[k]!=1){
				for( i=1 ; i <= n ; i++){
					if(i != k){
						for(j=1 ; j<= n ; j++){
							if( j!= k && j != i){
								int newVal = add(a[i][k],a[k][j]) + p[k];
								if(newVal!= 0 && newVal < a[i][j])
									a[i][j] = newVal;
							}// end of if
						}//end of loop j
					}//end of if i
				}//end of loop i
			}//end of if x
		}//end of loop k
		
		return a;
	}//end of function
	
	
	public int add(int a,int b){
		if(a == 0 || b == 0){
			return 0;
		}
		return a+b;

	}
	
	public void printPenaltyMtx(int p[]){
		for(int i=1; i<p.length ;i++)
			System.out.print(p[i]+" ");
		System.out.println();
	}
	
	public void checkForUNodes(int a[][],int n){
		int count = 0;
		int i = 1;
		for(i=1; i<a.length ; i++){
			for(int j=1; j<a[0].length ; j++){
				if(a[i][j] == 0)
					count++;
			}
			
			if(count == n){
				int x = i;
				for(i=1; i<a.length ; i++){
					a[i][x] = 0;
				}
				count = 0;
			}
				
		}
	}
}

package com.classes;

public class LoopsDemo {
	
	public int returnMax(int a,int b){
		return a>b? a:b;
	}
	
	public int returnMax3(int a,int b,int c){
		int max = (a>b ? a:b);
		return max >c ? max:c;
	}
	
	public String returnEvenOrOdd(int a){
		if(a%2 == 0)
			return "even";
		else
			return "odd";
	}
	
	public Boolean checkPrime(int n){
		for(int i=2;i<n ; i++){
			if(n%i == 0)
				return false;
		}
		
		return true;
	}
	
	public char toUpper(char a){
		if((int)a > 96){
			return (char)((int)a - 32);
		}
		else
			return a;
	}
	
	public char toLower(char a){
		int ascii = (int )a;
		if(ascii > 64 && ascii < 97){
			return (char)(ascii + 32);
		}
		else
			return a;
	}
	
	//Zodiac sign didnt understand what to do
	
	public int calculateFact(int n){
		int product = 1;
		for(int i=n ; i>0 ;i--){
			product *= i;
		}
		
		return product;
		
	}
	
	//check Palindrome
	public Boolean checkPalindrome(int n){
		
		
		return null;
	}
	
	//check Armstrong
	public Boolean checkArmstrong(int n){
		return null;
	}
	
	public int calculateCharge(int weight){
		if(weight >= 50){
			return 5;
		}
		else if(weight < 50 && weight >= 30)
			return 8;
		else if(weight < 30 && weight >= 10)
			return 10;
		else if(weight < 10)
			return 20;
		
		return 0;
	}
	
	//calculate rect  0  for area, anything else for perimeter
	public double calculateRect(float length,float breadth,int a){
		
		if(a == 0){
			return (length*breadth);
		}
		else{
			return (length+breadth);
		}
	}
	
	public int countDigits(int n){
		int count = 1;
		int res = n;
		while(res > 9){
			res = res / 10;
			count ++;
		}
		
		return count;
	}

	public int reverseDigit(int n){
		int digits = countDigits(n);
		int num = 0;
		int x = 0;
		
		for(int i=0 ; i<digits ; i++){
			x = n%10;
			n = n/10;
			if(i==0)
				num = x;
			else{
				num = num * 10+x;
			}
			
		}
		
		return num;
		
	}
	
//	int calcPowerof10(int pow){
//		int num = 1;
//		if(pow == 0)
//			return 1;
//		else{
//			for(int i=pow ; i>0 ;i--){
//				num = num * 10;
//			}
//		}
//		
//		return num;
//	}
	
	public int sumOfDigits(int n){
		int sum = 0;
		int digits = countDigits(n);
		int x = 0;
		for(int i=0 ; i<digits ; i++){
			x = n%10;
			n = n/10;
			if(i == 0)
				sum = x;
			else{
				sum += x;
			}
		}
		return sum;
		
	}
	
	public String sumEvenProdOdd(int n){
		int sum = 0;
		int prod = 1;
		
		for(int i=1;i<=n; i++){
			if(i%2 == 0)
				sum += i;
			else
				prod *= i;
			
			
		}
		return "Sum is"+sum+" Prod is "+prod;
	}
	
	public int[] fibonacci(int n){
		int arr[] = new int[n];
		if(n == 1){
			arr[0] = 1;
			return arr;
		}
		else if(n == 2){
			arr[0] = 1;
			arr[1] = 1;
		}
		else{
			arr[0] = 1;
			arr[1] = 1;
			for(int i=2;i<n ;i++){
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		return arr;
		
	}
}

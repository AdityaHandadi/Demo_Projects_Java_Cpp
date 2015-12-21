package com.man;

import java.util.Scanner;

import com.classes.Grades;
import com.classes.LoopsDemo;

public class Main {

	public static void main(String args[]){
		char a = 'a';
		char b = 'b';
		char A = 'A';
		char B = 'B';
		LoopsDemo someObj = new LoopsDemo();
		
		
		//System.out.println((int)a+" "+(int)b+" "+(int)A+" "+(int)B+" ");
		System.out.println(someObj.toLower(A));
		System.out.println(someObj.toUpper(b));
		System.out.println(someObj.toUpper(b));
		
		System.out.println("Is 23 prime? "+someObj.checkPrime(23));
		System.out.println("Is 24 prime? "+someObj.checkPrime(24));
		
		System.out.println("Max of 9 and 99 : "+someObj.returnMax(9, 99));
		System.out.println("Max of 1 9 and 99 : "+someObj.returnMax3(1, 9, 99));
		
		GradeService gradeService = new GradeService();
		Grades grade = new Grades();
		grade = gradeService.calculateGrades(10.0f, 20.0f, 90.0f, 90.0f, 90.0f);
		System.out.println("Class of 10,20,90,90,90: "+grade.getDivision());
		
		int sum = 0;
		//First ten natural numbers
		for (int i=1;i<= 10; i++){
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println("\n"+sum);
		
		System.out.println("Enter the number for fact :");
		Scanner scanner =  new Scanner(System.in);
		int n = scanner.nextInt();
		//int n = 10;
		//Calculate Factorial for 10
		System.out.println("Factorial: "+someObj.calculateFact(n));
		
		
		
		//Check Palindrome
		System.out.println("Calculate Weight : "+someObj.calculateCharge(25));
		
		System.out.println("Enter the number for digits and reverse : ");
		Scanner scanner_2 =  new Scanner(System.in);
		n = scanner_2.nextInt(); 
		//n = 2113;
		
		System.out.println("Digits "+someObj.countDigits(n));
		System.out.println("Rev "+someObj.reverseDigit(n));
		System.out.println("Sum of Digits "+someObj.sumOfDigits(n));
	
		n = 10;
		System.out.println("Sum of Evens and Prod of Odds for 10: "+someObj.sumEvenProdOdd(n));
		
		n = 10;
		int[] arr = someObj.fibonacci(n);
		for(int i=0 ; i<n ; i++){
			System.out.print(arr[i]+" ");
		}
		
		scanner.close();
		scanner_2.close();
	}
}

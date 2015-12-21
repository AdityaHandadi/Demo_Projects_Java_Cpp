package com.classes;

public class BasicFuncs {

	public int average(int a, int b, int c) {
		return a + b + c / 3;
	}

	public int simpleInterest(int p, int t, int r) {
		return p * t * r / 100;
	}

	public float celciusToFarhn(float temp) {
		return temp - 17.22f;
	}

	public int returnAscii(char c) {
		return (int) c;
	}

	public double calPower(int base, int power) {
		return Math.pow(base, power);
	}

	public float studentTotal(Student stu) {

		return stu.getSub1_marks() + stu.getSub2_marks() + stu.getSub3_marks()
				+ stu.getSub4_marks() + stu.getSub5_marks();
	}
	
	public double calculateDiscount(Product product){
		if(product.getProductName().toLowerCase() == "laptop"){
			return product.getPrice()*0.85;
		}
		else{
			return product.getPrice()*0.90;
		}
	}
	
	public double calculator(int a , int b , char c){
		Double res = null;
		switch(c){
		case '+':
			res =  (double) (a+b);
		case '-':
			res =  (double) (a-b);
		case '/':
			res =  (double) (a/b);
		case '*':
			res =  (double) (a*b);
		case '%':
			res =  (double) (a%b);
		
		}
		
		return res;
	}
	
	
	public Triangle calculateTriangle(Triangle triangle){
	 
	 triangle.setHypotenuse(Math.sqrt((triangle.getBase()*triangle.getBase())+(triangle.getHeight()*triangle.getHeight())));
	 triangle.setArea((triangle.getBase()*triangle.getHeight())/2);
	 
	 return triangle;
	}
	
}
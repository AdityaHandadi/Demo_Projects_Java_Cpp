package com.classes;

public class Rectangle {
	
	int length;
	int breadth;
	int area;
	int perimeter;
	double diagonal;
	
	
	public Rectangle() {
		super();
	}
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
	public double getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	
	public void input(int length,int breadth)
	{
		this.length = length;
		this.breadth = breadth;
	}
	public  void calculate(){
		this.area = length * breadth;
		this.perimeter = length + breadth;
		this.diagonal = Math.sqrt((length*length)+(breadth*breadth));
	}
	
	public  void output(){
		System.out.println("Area: "+area +" Perimeter: "+perimeter+" "+"Diagonal: "+diagonal);
	}
}

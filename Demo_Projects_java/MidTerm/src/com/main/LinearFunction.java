package com.main;

public class LinearFunction implements MathFunction{

	private int m;
	private int b;

	public LinearFunction(int m, int b) {
		super();
		this.m = m;
		this.b = b;
	}

	@Override
	public double evaluate(double x) {
		return ((this.m*x)+this.b);
	}

	@Override
	public String toString() {
		return "f(x) = "+this.m+"x+("+this.b+")";
	}

	
}

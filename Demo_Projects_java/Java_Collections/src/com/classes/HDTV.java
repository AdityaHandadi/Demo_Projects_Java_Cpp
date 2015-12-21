package com.classes;


public class HDTV {

	private int size;
	
	private String brand;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public HDTV(int size, String brand) {
		super();
		this.size = size;
		this.brand = brand;
	}
}

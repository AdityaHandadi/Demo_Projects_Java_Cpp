package com.classes;

public class StaffProduct extends com.abs.classes.Product {

	public StaffProduct(int productId, String productName, String description,
			float price, float markUp) {
		super(productId, productName, description, price, markUp);
		// TODO Auto-generated constructor stub
	}

	
	public double getTotalPrice() {
		double newPrice = price + (price*.04);
		return newPrice;
	}
	
}

package com.classes;

public class CustomerProduct extends com.abs.classes.Product {

	public CustomerProduct(int productId, String productName,
			String description, float price, float markUp) {
		super(productId, productName, description, price, markUp);
		// TODO Auto-generated constructor stub
	}
	
	public double getTotalPrice() {
		double newPrice = price + (price*.04) + markUp;
		return newPrice;
	}

}

package com.abs.classes;

public abstract class Product {
	
	public int productId;
	public String productName;
	public String description;
	public float price;
	public float markUp;
	

	public double getTotalPrice() {
		return 0;
	}


	public Product(int productId, String productName, String description,
			float price, float markUp) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.markUp = markUp;
	}


	
	
}

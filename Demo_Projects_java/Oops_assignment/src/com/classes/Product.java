package com.classes;

public class Product implements Mrp{

	private int id;
	private String name;
	private String description;
	private Double unitPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Product getData(){
		return this;
	}
	
	public void setData(Product product){
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.unitPrice = product.getUnitPrice();
		
	}
	
	
	public void display() {
		System.out.println("Id: " + getId() + " Name: " + getName()
				+ " Description: " + getDescription() + " " + "Price Rs."
				+ unitPrice);
	}
	
	@Override
	public double calculateMRP(float vat, float cess) {
		double newVat = (unitPrice*vat)/100;
		double mrp = unitPrice + newVat + cess;
		return mrp;
	}
}

package com.classes;

public class BillGenerator {
	
	public void calculateDiscount(double amount,int quantity,float discountPercent){
		double disCnt = discountPercent/100*amount;
		amount = amount - disCnt;
		System.out.println("New Amount "+quantity*amount);
		
	}
	
	public double calculateTotalDiscount(BillItem item,float discountPercent){
		double price = item.getUnitPrice();
		double deduct = discountPercent/100*price;
		item.setUnitPrice(price - deduct);
		
		return item.getUnitPrice();
		
	}

}

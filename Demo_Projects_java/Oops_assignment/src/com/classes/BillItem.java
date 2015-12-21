package com.classes;

public class BillItem {

	private int productId;
	private String productName;
	private Double unitPrice;
	private int quantity;
	private Double totalDiscount;
	
	
	public BillItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BillItem(int productId, String productName, Double unitPrice,
			int quantity, Double totalDiscount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalDiscount = totalDiscount;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Double getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	
	
}

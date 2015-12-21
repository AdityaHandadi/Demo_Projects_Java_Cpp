package com.classes;

public class ProductInfo {

	private int productId;
	
	private String productName;
	
	private String productCode;
	
	private String description;
	
	private Double unitPrice;

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(int productId, String productName, String productCode,
			String description, Double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = unitPrice;
	}
	
	public ProductInfo(int productId, String productName,Double unitPrice){
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.productCode = productName+productId;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	
	
}

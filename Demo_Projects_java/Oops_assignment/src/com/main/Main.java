package com.main;

import com.classes.BillGenerator;
import com.classes.BillItem;
import com.classes.CustomerProduct;
import com.classes.Product;
import com.classes.ProductInfo;
import com.classes.Rectangle;
import com.classes.Security;
import com.classes.StaffProduct;

public class Main {

	public static void main(String args[]){
		Rectangle rect = new Rectangle();
		
		rect.input(5,10);
		rect.calculate();
		rect.output();
		
		Security sec = new Security("Bhajrangi",47,0,0);
		sec.calWage();
		sec.display();
		
		Product product = new Product();
		product.setId(1);
		product.setDescription("Hawa Badlegi");
		product.setName("Havells Fans ");
		product.setUnitPrice(2000.50);
		
		Product product_2 = new Product();
		product_2.setId(2);
		product_2.setDescription("Chutki me Chipkaye");
		product_2.setName("Fevi Quick ");
		product_2.setUnitPrice(5.0);
		
		product.display();
		product_2.display();
		
		ProductInfo prodInfo = new ProductInfo();
		prodInfo = new ProductInfo(123,"ParleG",23.45);
		
		System.out.println(prodInfo.getProductCode());
		
		System.out.println(product.calculateMRP(5.0f, 10.0f));
		
		BillItem billInfo = new BillItem();
		billInfo.setProductId(1);
		billInfo.setProductName("ABC");
		billInfo.setQuantity(10);
		billInfo.setTotalDiscount(2.5);
		billInfo.setUnitPrice(100.00);
		
		System.out.println(billInfo.getUnitPrice());
		
		BillGenerator billGen = new BillGenerator();
		billGen.calculateTotalDiscount(billInfo, 3.0f);
		
		System.out.println(billInfo.getUnitPrice());
		
		StaffProduct staff = new StaffProduct(1, "abc", "asdasdasd", 23.45f, 3);
		CustomerProduct cust = new CustomerProduct(1, "def", "asdsad", 23.45f, 3);
		
		System.out.println(staff.getTotalPrice());
		System.out.println(cust.getTotalPrice());
		
	}
}

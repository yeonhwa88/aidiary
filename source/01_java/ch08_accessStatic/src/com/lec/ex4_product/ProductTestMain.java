package com.lec.ex4_product;

public class ProductTestMain {
	public static void main(String[] args) {
		System.out.println(Product.count);
		Product p1 = new Product("S23");
		p1.infoprint();
		System.out.println(Product.count);
		Product p2 = new Product("S23");
		Product p3 = new Product("S23");
		p2.infoprint();
		p3.infoprint();
	}
}

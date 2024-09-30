package com.lec.ex4_product;

public class ProductTestMain1 {
	public static void main(String[] args) {
		System.out.println(Product1.count);
		Product1 p1 = new Product1("S35");
		p1.infoprint();
		System.out.println(Product1.count);
		Product1 p2 = new Product1("S35");
		Product1 p3 = new Product1("S35");
		p2.infoprint();
		p3.infoprint();
	}

}

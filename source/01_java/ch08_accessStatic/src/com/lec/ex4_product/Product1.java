package com.lec.ex4_product;

public class Product1 {
	private String modelNo;
	private int serialNo;
	static int count = 100;
	public Product1(String modelNo) {
		this.modelNo=modelNo;
		serialNo = ++count;
	}
	public void infoprint() {
		System.out.println("모델명 : " + modelNo + "시리얼 번호 : " + serialNo);
	}
}

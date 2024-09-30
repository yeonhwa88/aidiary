package com.lec.ex2_protected;

public class Child1 extends SuperIJ1 {
	private int total;
	public Child1() {
		System.out.println("매개변수 없는 Child 생성자 ");
	}
	public Child1(int i , int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 child 생성자");
	}
	public void sum() {
		total = i+ j;
		System.out.println(" i =" + i + "j =" + j + "total = " + total);
	}

}

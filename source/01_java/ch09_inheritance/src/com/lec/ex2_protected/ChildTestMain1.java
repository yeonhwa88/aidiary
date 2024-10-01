package com.lec.ex2_protected;

public class ChildTestMain1 {
	public static void main(String[] args) {
		Child1 child = new Child1();
		child.setI(1); child.setJ(2);
		child.sum();
		System.out.println("======================");
		Child1 child2 = new Child1();
		child2.sum();
	}

}

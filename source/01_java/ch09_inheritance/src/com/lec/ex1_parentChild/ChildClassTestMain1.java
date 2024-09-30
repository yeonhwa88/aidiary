package com.lec.ex1_parentChild;

public class ChildClassTestMain1 {
	public static void main(String[] args) {
		ChildClass1 child = new ChildClass1();
		System.out.println(child.cStr);
		System.out.println(child.pStr);
		child.getMamiName();
		child.getPapaName();
	}

}

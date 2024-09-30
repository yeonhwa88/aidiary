package com.lec.ex3_static;

public class MomTestMain1 {
	public static void main(String[] args) {
		Child.method();
		System.out.println(Child1.mom.money);
		Child1 child1 = new Child1("첫째 개똥");
		Child1 child2 = new Child1("둘째 똥개");
		Child1 child3 = new Child1("셋째 개순");
		System.out.println("엄마지갑 : " + Child1.mom.money);
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println("엄마지갑 : "+ child1.mom.money);
		System.out.println("엄마지갑 : "+ child2.mom.money);
		System.out.println("엄마지갑 : "+ child3.mom.money);
	}

}

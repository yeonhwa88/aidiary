package com.lec.ex4_override;

public class Parent1 {
	public Parent1() {
		System.out.println("매개변수 없는 Parent 생성자");
	}
	public Parent1(int i) {
		System.out.println("매개변수 있는 Parent 생성자");
	}
	public void method1() {
		System.out.println("Parent 의 method1");
	}
	public void method2() {
		System.out.println("Parent 의 method2");
	}

}

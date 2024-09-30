package com.lec.ex4_override;

public class Child1 extends Parent1{
	public Child1() {
		System.out.println("매개변수 없는 Child 생성자");
	}
	public Child1(int i) {
		System.out.println("매개변수 있는 Child 생성자");
	}
	@Override
	public void method1() {
		System.out.println("Child의 method1()");
	}
	public void method3() {
		System.out.println("Child의 method3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}

}

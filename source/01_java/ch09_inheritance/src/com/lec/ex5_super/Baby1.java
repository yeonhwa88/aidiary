package com.lec.ex5_super;

public class Baby1 extends Person1{
	public Baby1() {
		super(); // 부모클래스의 매개변수 없는 생성자 함수 호출
		System.out.println("매개변수 없는 Baby 생성자 호출");
	}
	public Baby1(String name, String charater) {
		super(name, charater);
		System.out.println("매개변수 있는 Baby 생성자 호출");
	}
	@Override
	public void intro() {
		System.out.println("응애응애 귀여운 아기");
		super.intro();
	}
}

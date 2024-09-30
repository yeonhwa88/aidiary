package com.lec.ex3_static;

public class Child1 {
	private String name;
	static Mom mom = new Mom(); // defalut값 같은패키지에선 public 다른패키지에선 private
	public Child1(String name) {
		this.name=name;
	}
	public static void method() {
		System.out.println("method");
	}
	public void takeMoney(int money) {
		if (mom.money >= money) {
			mom.money -= money;
			System.out.println(name + "가" + money + "원 가져가서 엄마 지갑엔" +mom.money);
		}else {
			System.out.println(name + "가 돈 못받음 현재 엄마 지갑엔 " + mom.money );
		}
	}
}

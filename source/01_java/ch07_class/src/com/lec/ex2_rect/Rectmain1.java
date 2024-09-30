package com.lec.ex2_rect;

public class Rectmain1 {
	public static void main(String[] args) {
		Rect1 r1 = new Rect1();
		Rect1 r2 = new Rect1(3);
		Rect1 r3 = new Rect1(2, 4);
		System.out.printf("r1의 데이터 : %d, %d\n", r1.getWidth(), r1.getHeight());
		System.out.printf("r2의 데이터 : %d, %d\n", r2.getWidth(), r2.getHeight());
		System.out.printf("r3의 데이터 : %d, %d\n", r3.getWidth(), r3.getHeight());
		r1.setWidth(10); r1.setHeight(5);
		System.out.printf("r1넓이 : %d\n", r1.area());
		System.out.printf("r1넓이 : %d\n", r2.area());
		System.out.printf("r1넓이 : %d\n", r3.area());
	}
}

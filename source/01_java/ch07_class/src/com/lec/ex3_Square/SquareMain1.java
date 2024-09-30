package com.lec.ex3_Square;

public class SquareMain1 {
	public static void main(String[] args) {
		Square1 s1 = new Square1(); // 디폴트 매개변수
		System.out.println("s1의 한변은" + s1.getSide());
		s1.setSide(6);
		System.out.println("수정된 s1의 넓이는\t" + s1.area());
		System.out.println("------------------------------");
		Square1 s2 = new Square1(10);
		System.out.println("s2의 한변은" + s2.getSide());
		System.out.println("수정된 s2의 넓이는\t" + s2.area());
	}

}

package com.lec.ex3_Square;

public class Square1 {
	private int side;
	public Square1() {
		System.out.println("매개변수 없는 생성자 함수 호출");
	}
	public Square1(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출");
	}
	public int area() {
		return side*side;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	
}

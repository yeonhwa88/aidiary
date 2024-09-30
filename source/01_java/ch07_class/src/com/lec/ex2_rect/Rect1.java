package com.lec.ex2_rect;

public class Rect1 {
	private int width;
	private int height;
	// 생성자 함수
	public Rect1() {} //default 생성자
	public Rect1(int side) {
		width = side;
		height = side;
	}
	public Rect1(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int area() {
		return width*height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

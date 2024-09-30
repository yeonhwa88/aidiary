package com.lec.ex1_car;

public class Car1 {
	private String color;
	private int cc;
	private int speed;

	public Car1() {}

	public void park() {
		speed = 0;
		System.out.println(color + " 색 주차함 . 지금속도 :" + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + " 색 주행중 . 지금속도 :" + speed);
	}
	public void race() {
		speed = 300;
		System.out.println(color + " 색 레이싱함 . 지금속도 :" + speed);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.
		cc = cc;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

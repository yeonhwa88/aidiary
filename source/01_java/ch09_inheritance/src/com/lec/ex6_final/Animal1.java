package com.lec.ex6_final;

public class Animal1 {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("동물이 뛰고있어요 현재속도 : " + speed);
	}
	public final void stop() {
		speed = 0;
		System.out.println("멈춤");
	}

}

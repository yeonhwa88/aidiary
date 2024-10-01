package com.lec.ex6_final;

public class Rabbit1 extends Animal1{
	@Override
	public void running() {
		speed += 20;
		System.out.println("토끼가 마구 뛰어요. 현재 속도 : " +speed);
	}

}

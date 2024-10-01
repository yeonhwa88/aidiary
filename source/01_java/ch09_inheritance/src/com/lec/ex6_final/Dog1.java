package com.lec.ex6_final;

public class Dog1 extends Animal1{
	@Override
	public void running() {
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들어요. 현재속도 : " + speed);
	}
}

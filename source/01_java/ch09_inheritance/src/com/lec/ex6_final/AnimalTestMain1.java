package com.lec.ex6_final;

public class AnimalTestMain1 {
	public static void main(String[] args) {
		Animal1[] animals = {new Animal1(), new Dog1(), new Rabbit1()};
		for(int idx = 0 ; idx<animals.length ; idx++) {
			animals[idx].running();
			animals[idx].running();
			animals[idx].stop();
			System.out.println("===============");
		}
	}
}

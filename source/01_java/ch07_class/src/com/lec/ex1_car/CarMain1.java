package com.lec.ex1_car;

public class CarMain1 {
	public static void main(String[] args) {
		Car1 mycar = new Car1();
		mycar.setColor("레드");
		mycar.setCc(1200);
		System.out.println(mycar.getColor() + "색 차 배기량" + mycar.getCc());
		mycar.drive();
		mycar.park();
		mycar.race();
		System.out.println(mycar.getColor() + "색 차 배기량 "+ mycar.getCc());
		Car yourcar = new Car();
		yourcar.setColor("블랙");
		yourcar.setCc(1500);
		yourcar.setSpeed(150);
		System.out.println(yourcar.getColor() + "색 차 배기량 " + yourcar.getCc());
		yourcar.drive();
		yourcar.park();
		yourcar.race();
		System.out.println(yourcar.getColor() + "색 차 배기량" + yourcar.getCc());

	}
}

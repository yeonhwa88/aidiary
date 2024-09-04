package exex;

public class Car {
	private String color;
	private int cc;
	private int speed;
	//생성자 함수
	public Car() {}
	public void park() {
		speed = 0;
		System.out.println(color + "색 주차함 . 지금속도 :" + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "색 드라이브 함. 지금속도 :" + speed);
	}
	public void race() {
		speed = 200;
		System.out.println(color + "색 레이스 중. 지금속도 :" + speed);
	}
	// setters & getters 
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
		this.cc = cc;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

}

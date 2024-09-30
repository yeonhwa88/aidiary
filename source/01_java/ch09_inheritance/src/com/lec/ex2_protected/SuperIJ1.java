package com.lec.ex2_protected;

public class SuperIJ1 {
	protected int i;
	protected int j;
	public SuperIJ1() {
		System.out.println("매개변수 없는 SuperIJ1 생성자 함수");
	}
	public SuperIJ1(int i, int j) {
		System.out.println("매개변수 있는 SuperIJ1 생성자 함수");
		this.i = i;
		this.j = j;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}

}

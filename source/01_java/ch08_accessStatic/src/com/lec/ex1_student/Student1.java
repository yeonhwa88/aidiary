package com.lec.ex1_student;
//데이터 : name(String), kor(int), eng(int) mat(int) tot(int) avg(double)
//생성자 : new Student("정우성",90,90,90)
//메소드 : infoprint(), infoString()
public class Student1 {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public Student1() {	}
	public Student1(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.;
	}
	public void infoprint() {
		System.out.printf("\t%s \t%3d \t%3d \t%3d \t%3d \t%.2f", name,kor,eng,mat,tot,avg);
	}
	public String infoString() {
		return String.format("\t%s \t%3d \t%3d \t%3d \t%3d \t%2f", name,kor,eng,mat,tot,avg);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

}

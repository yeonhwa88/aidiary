package com.lec.dto;

public class Person {
	private int pno;
	private String pname;
	private String jname;
	private int jno;
	private int kor;
	private int eng;
	private int mat;
	public Person(int pno, String pname, String jname, int jno, int kor, int eng, int mat) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.jname = jname;
		this.jno = jno;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	@Override
	public String toString() {
		return pno + "\t" + pname + "\t" + jname + "\t" + jno + "\t" + kor
				+ "\t" + eng + "\t" + mat;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
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

	}
	
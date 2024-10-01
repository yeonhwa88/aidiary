package com.lec.ex5_super;

public class TestMain1 {
	public static void main(String[] args) {
		Person1 papa = new Person1();
		papa.setName("아빠곰");
		papa.setCharater("뚱뚱해");
		papa.intro();
		Person1 mom = new Person1("엄마곰", "날씬해");
		mom.intro();
		Baby1 baby1 = new Baby1();
		Baby1 baby2 = new Baby1("아기곰", "너무귀여워");
		baby1.setName("작은아기곰");
		baby1.setCharater("너무 귀여워");
		baby1.intro();
		baby2.intro();
	}

}

package com.lec.ex;

public class Ex04_void01 {
	public static void printLine(int cnt,String ch) {
		for(int i = 0; i<50 ; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	private static void printLine(String ch) {
		for(int i=0 ; i<20 ; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	private static void printLine(int cnt) {
		for(int i=0 ; i<cnt ; i++) {
			System.out.println("-");
		}
		System.out.println();
	}
	public static void printLine() {
		for(int i=0; i<20 ; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}

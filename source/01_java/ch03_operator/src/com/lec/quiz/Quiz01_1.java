package com.lec.quiz;

import java.util.Scanner;

public class Quiz01_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요");
		int su = sc.nextInt();
		int su1 = su%2;
		System.out.println((su1==0)? "짝수입니다":"홀수입니다");
	}
}
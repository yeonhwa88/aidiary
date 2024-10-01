package com.lec.quiz;

import java.util.Scanner;

public class Quiz02_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
//		sum = kor + eng + mat;
		System.out.print("국어점수 입력해 주세요:");
		int kor = sc.nextInt();
		System.out.print("영어점수 입력해 주세요");
		int eng = sc.nextInt();
		System.out.print("수학점수 입력해 주세요");
		int mat = sc.nextInt();
		System.out.printf("kor = %d + eng = %d + mat = %d = 총 합계는 %d", kor,eng,mat,kor+eng+mat);
	}
}

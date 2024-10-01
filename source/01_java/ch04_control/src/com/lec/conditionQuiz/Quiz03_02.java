package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz03_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2)중 하나를 선택하세요 :");
		int num = sc.nextInt();
		System.out.println((num == 0)? "가위" : (num == 1)? "바위":"보");
		
	}
}
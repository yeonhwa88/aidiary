package com.lec.conditionQuiz;

import java.util.Scanner;

//수를 입력받아 절대값을 출력하는 프로그램

public class Quiz1_01 {
 public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.print("숫자를 입력해 주세요");
	int num = sc.nextInt();
	
	if (0>num) {
		System.out.printf("절대값은 %d",-num);		
	}else {
		System.out.printf("절대값은 %d", num);
	}
}
}

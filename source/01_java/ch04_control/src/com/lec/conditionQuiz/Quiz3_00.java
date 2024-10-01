package com.lec.conditionQuiz;

import java.util.Scanner;
//가위바위보 중 하나를 내고(scanner.nextInt()사용) 낸 것을 출력하세요. 
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 합니다.
public class Quiz3_00 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("가위(0),바위(1),보(2)중 하나 입력하세요>");
		int g = sc.nextInt();
		String user;
		if (g == 0) {
			user = "가위";			
		}else if (g == 1) {
			user = "바위"	;		
		}else if ( g == 2) {
			user = "보";
		}else {
			System.out.println("재입력하세요");
		}
		System.out.println("당신이 낸 것은"+ g);
	}
}

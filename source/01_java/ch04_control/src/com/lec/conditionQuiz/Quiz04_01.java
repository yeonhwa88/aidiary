package com.lec.conditionQuiz;
//사용자에게 가위(0),바위(1),보(2) 입력받는다 
//1. 0~2사이의 수를 입력 안 한 경우 : 프로그램 강제 종료
//2. 0~2사이의 수를 입력 한 경우 (if, switch, 삼항연산자)
//    (1)컴퓨터가 0~2사의 난수를 발생
//    (2)당신과 컴퓨터가 낸 가위바위보 출력 (ex. 당신 가위, 컴퓨터는 바위)
//    (3)가위바위보 결과 출력(ex 당신이 졌습니다 ㅠ.ㅠ)

import java.util.Scanner;

public class Quiz04_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("가위(0),바위(1),보(2)");
		int user = sc.nextInt();
		if (user < 0 || user > 2) {
			System.out.print("다시하세요");
			System.exit(0);
		}
		System.out.print("당신은\t");
		System.out.println((user == 0)? "가위":(user == 1) ? "바위":"보");
		int com = (int)(Math.random()*3);
		System.out.print("컴터는\t");
		System.out.println((com == 0)? "가위":(com == 1)? "바위":"보");
		if (user == com) {
			System.out.println("비겼습니다");
		}else if (user < com) {
			System.out.println("졌습니다");
		}else if (user > com) {
			System.out.println("이겼습니다");
		} 
	}
}

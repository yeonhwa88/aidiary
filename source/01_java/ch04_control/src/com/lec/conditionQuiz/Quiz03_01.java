package com.lec.conditionQuiz;
//가위바위보 중 하나를 내고(scanner.nextInt()사용) 낸 것을 출력하세요. 
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 
//보를 선택하고자 할 때는 2를 입력하여 합니다.
import java.util.Scanner;

public class Quiz03_01 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("가위(0),바위(1),보(2) >");
	int num1 = sc.nextInt();
	String uesr;
	switch(num1) {
	case 0:
		uesr = "가위"; break;
	case 1:
		uesr = "바위"; break;
	case 2:
		uesr = "보"; break;
	default:
		uesr = "다시 내세요";
		}
		System.out.println(uesr);
	}
}
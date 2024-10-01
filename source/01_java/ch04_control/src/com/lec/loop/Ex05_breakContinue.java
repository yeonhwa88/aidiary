package com.lec.loop;

public class Ex05_breakContinue {
	public static void main(String[] args) {
		for(int i = 1 ; i <= 10; i++) {
			if(i == 3) {
				//break; // 반복문 출력 빠져 나감
				continue; // 증감식으로 올라가서 재실행 // 사용 적음
			}
			System.out.print(i + "\t");
		}
	}
}

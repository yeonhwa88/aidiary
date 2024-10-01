package com.lec.conditionQuiz;

//두 수 중 큰 수를 변수 max에 입력하고 변수 max를 출력하는 프로그램입니다. 잘못된 부분은?
public class Quiz2_02 {
	public class Quiz2 {
		public static void main(String[] args) {
			int num1 = 27;
			int num2 = 32;
			if (num1 > num2) {
				int max = num1;
				System.out.println(max);
			} else {
				int max = num2;
				System.out.println(max);
			}
		}
	}

}

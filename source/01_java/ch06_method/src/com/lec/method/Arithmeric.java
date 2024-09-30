package com.lec.method;
//sum(10, 100) sum(10) (매개변수는 1개에서 2개까지만 ) - 함수 오버로딩 / evenOdd(10) / abs(-9) 
public class Arithmeric {
	public static int abs(int value) {
		int result = (value >= 0) ? value : -value; //삼항연산자
		return result;
	}
	public int sum(int from, int to) { // from 부터 to 까지 더한수
		int sum = 0;
		for(int i=from ; i<= to ; i++) {
			sum += i;
		}
		return sum;
	}
	public int sum(int to) {
		int result = 0;
		for(int i=1; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		String result = (value%2 ==0) ? "짝수입니다" : "홀수입니다"; //짝수 홀수 변수 % 2 == 0
		return result;
	}
}

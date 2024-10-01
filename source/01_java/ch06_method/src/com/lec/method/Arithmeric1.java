package com.lec.method;

public class Arithmeric1 {
	public static int abs(int value) {
		int result = (value >=0 )? value : -value;
		return result;
	}
	public int sum(int form, int to) {
		int sum = 0;
		for(int i=0; i<=to ; i++) {
			sum += i;
		}
		return sum;
	}
	public int sum (int to) {
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		String result = (value%2 == 0) ? "짝수입니다" : "홀수입니다";
		return result;
	}
}

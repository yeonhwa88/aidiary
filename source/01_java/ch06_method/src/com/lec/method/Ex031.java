package com.lec.method;

public class Ex031 {
	public static void main(String[] args) {
		System.out.println("-7의 절대값 : " + Arithmeric.abs(-7));
		Arithmeric ar = new Arithmeric();
		int tot = ar.sum(10,100);
		int tot2 = ar.sum(30);
		System.out.println("합은 ? "+ tot);
		System.out.println("합은 ? "+ tot2);
		System.out.println(ar.evenOdd(tot2));
		System.out.println(ar.evenOdd(tot));
		
	}

}

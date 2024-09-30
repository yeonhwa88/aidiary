package com.lec.ex4_account;

public class AccountTestMain1 {
	public static void main(String[] args) {
		Account hong = new Account("100-1", "홍길동");
		hong.deposit(100); //예금
		hong.withdraw(150);//출금
		hong.infoPrint();
		System.out.println(hong.infoString());
		Account hong1 = new Account("010-2", "홍길순", 2200000000L);
		hong1.withdraw(2000);//출금
		System.out.println(hong1.infoString());
	}
}

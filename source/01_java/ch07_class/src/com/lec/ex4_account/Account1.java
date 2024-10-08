package com.lec.ex4_account;
//데이터(인스턴스변수) : accountNo(String), ownerName(String),balance(long)
//생성자 new Account("010-777-77", "홍길동"), new Account("010-777-77", "홍길동", 100)
//기능(메서드) : deposit(예금), withdraw(인출), infoPrint(정보출력), infoStrin(정보문자열 반환)
public class Account1 {
	private String accountNo;//계좌번호
	private String ownerName;//예금주
	private long balance;// 예금잔액
	public Account1(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account1(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(long money) { //무조건 예금하기
		balance += money;
		System.out.println(money + "원 예금하여 잔액 : " + balance+ "원");
	}
	public void withdraw(long money) { // 잔액이 있을 경우만 인출하기
		if(balance >= money) {
			balance -= money;
//			balance = balance - money;
			System.out.println(money + "원 인출하여 잔액 :" + balance + "원");
		}else {
			System.out.println("잔액이 부족하여 인출 불가합니다 .");
		}			
	}
	public void infoPrint() {
		System.out.printf("%s \"%s\"님 잔액 : %d", accountNo, ownerName, balance);
	}
	public String infoString() {
		return String.format("%s \"%s\"님 잔액 : %d", accountNo, ownerName, balance);
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}

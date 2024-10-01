package com.lec.ex3_abc;

public class ABCTestMain1 {
	public static void main(String[] args) {
		S1 sobj = new S1();
		S1 aobj = new A1();
		S1 bobj = new B1();
		C1 cobj = new C1();
		S1[] arr = {sobj, aobj, bobj, cobj};
		for(S1 temp : arr) {
			System.out.println(temp.s);
		}
	}
}

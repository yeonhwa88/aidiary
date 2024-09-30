package com.lec.ex4_override;

public class TestMain1 {
	public static void main(String[] args) {
		Parent1 pObj1 = new Parent1();
		Parent1 pObj2 = new Parent1();
		System.out.println("pObj1과 pObj2는 같은지?" +(pObj1.equals(pObj2)));
		pObj1.method1();
		pObj2.method2();
		Child1 cObj1 = new Child1();
		Child1 cObj2 = new Child1();
		System.out.println("cObj1과 cObj2는 같은지?" +(cObj1.equals(cObj2)));
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
		Parent1 obj = new Child1();
		obj.method1();
		obj.method2();
		if(obj instanceof Child1) {
			((Child1)obj).method3();			
		}else {
			System.out.println("형변환 불가");
		}
	}

}

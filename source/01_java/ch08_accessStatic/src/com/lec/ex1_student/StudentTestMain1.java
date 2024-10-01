package com.lec.ex1_student;

public class StudentTestMain1 {
	private static void line() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print("■");
		}
		System.out.println(); // 개행
	}
	private static void line(char ch) {
		System.out.print("\t");
		for (int i=0 ; i<50 ; i++) {
			System.out.print(ch);
		}
		System.out.println(); // 개행
	}
	public static void main(String[] args) {
		Student1[] students = {new Student1("정우성",90,90,90),
							new Student1("김하늘",85,85,85),
							new Student1("황정민",80,80,80),
							new Student1("강동원",75,75,75),
							new Student1("마동석",70,70,70)};
		String[] titles = {"이름","국어","영어","수학","총점","평균"};
		int [] tot = new int [5];
		line();
		System.out.println("\t\t\t\t성적표");
		line('-');
		for(String title : titles) {
			System.out.print("\t" + title);
		}
		System.out.println(); // 개행
		line('-');
		for(Student1 student : students) {
			System.out.println(student.infoString());
			tot[0] += student.getKor();
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		line('-');
		System.out.print("\t 총점");
		for(int t : tot) {
			System.out.print("\t " + t);
		}
		System.out.println(); //개행
		line();
	}
}

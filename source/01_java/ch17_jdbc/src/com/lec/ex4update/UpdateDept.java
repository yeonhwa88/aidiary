package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호, 부서명, 부서위치를 받아 update
public class UpdateDept {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner	sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.print("수정할 부서 번호는 ?");
		int deptno = sc.nextInt();
		// 부서번호 존재 여부 confirm
		System.out.print("수정할 부서 이름은 ?");
		String dname =sc.next();
		System.out.print("수정할 부서 지역은 ?");
		String loc = sc.next(); 
		String sql = String.format("UPDATE DEPT "
				+ "    SET DNAME = UPPER('%s'),"
				+ "          LOC = UPPER('%s')"
				+ "    WHERE DEPTNO = %d", dname, loc, deptno);
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0? "수정성공" : "해당부서가 없어서 수정불가");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		
	}// try ~catch finally
}//main
}//class
package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호 중복체크후, 부서명, 근무지를 입력받아 insert
public class InsertDeptConfirm {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력할 부서번호는 >");
		int deptno = sc.nextInt();
		// deptno 중복 체크
		String confirmsql = "SELECT COUNT(*) CNT"
				+ "    FROM DEPT WHERE DEPTNO = " + deptno;
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confirmsql);
			rs.next();
			int cnt = rs.getInt(1); // 1번째 열을 가져옴
			if(cnt ==0) {
				// insert 수행
				System.out.print("입력할 부서명은 >");
				String dname = sc.next();
				System.out.print("입력할 부서위치는 >");
				String loc = sc.next();
				String insertsql = String.format("INSERT INTO DEPT "
					   +" VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc);
				int result = stmt.executeUpdate(insertsql);
				if(result > 0) {
					System.out.println("입력성공");
				}
			}else
				System.out.println("중복된 부서번호는 입력 불가");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(conn!=null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		
		}
	}
}

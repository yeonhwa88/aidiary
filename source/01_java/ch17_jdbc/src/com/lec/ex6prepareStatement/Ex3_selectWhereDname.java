package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//com.lec.ex2selectWhere + com.lec.ex3selectWhere
//부서명을 입력받아 해당 부서 정보를 출력하고, 사원을 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String deptsql = "SELECT *"
				+ "    FROM DEPT"
				+ "    WHERE DNAME = UPPER(?)";
		String empsql = "SELECT EMPNO, ENAME, SAL"
				+ "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO = D.DEPTNO"
				+ "     AND DNAME = UPPER(?)"
				+ "    ORDER BY SAL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(deptsql);
			System.out.print("입력할 부서 이름은 ?");
			String dname = sc.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("부서번호 : "+ rs.getInt("deptno"));
				System.out.println("부서이름 :" + rs.getString("dname"));
				System.out.println("부서위치 : "+ rs.getString("loc"));
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(empsql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					do{
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						System.out.println(empno + "\t" + ename + "\t" + sal);
					}while (rs.next());
				}else {
					System.out.println("사원은 없어");
				}
			}else {
				System.out.println("입력하신 부서명은 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
}

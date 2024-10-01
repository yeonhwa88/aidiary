package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDeptconfrim {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner	sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("수정할 부서 번호는 ?");		
		int deptno = sc.nextInt();
		// 부서번호 존재 여부 confirm
		String confrimspl = "SELECT *"
				+ "    FROM DEPT"
				+ "    WHERE DEPTNO = "+ deptno;
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confrimspl);
			if(rs.next()) {
				System.out.print("수정할 부서 명은 ?");
				String dname = sc.next();
				System.out.println("수정할 부서 위치는 ?");
				String loc = sc.next();
				String updatesql = String.format("UPDATE DEPT "
									+" SET DNAME = UPPER('%s'),"
									+" 	LOC = UPPER('%s')"
									+" WHERE DEPTNO = %d", dname, loc, deptno);
				int result = stmt.executeUpdate(updatesql);
				if(result>0) {
					System.out.println("수정성공");
				}
				
			}else {
				System.out.println(deptno+ "번은 중복된 부서번호 입니다");
			}
			
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

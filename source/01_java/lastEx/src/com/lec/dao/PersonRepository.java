package com.lec.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Person;

public class PersonRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getInstance() {
		return INSTANCE;
	}
	// 1번기능과 2번 기능에서 입력가능한 직업명들을 출력 (jnameList)
	private PersonRepository() {}
	public ArrayList<String> jnameList() {
		ArrayList<String> person = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME"
				+ "    FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				person.add (rs.getString("jname"));	
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
		return person;
	}
	//1번 기능 : PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON테이블 INSERT  (insertPerson)
	public int insertPerson(String pname, String jname, int kor, int eng, int mat){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON (PNO, PNAME, JNO, KOR, ENG, MAT)"
				+ "    VALUES (PERSON_PNO_SQ.NEXTVAL, ?, (SELECT JNO"
				+ "                                FROM JOB"
				+ "                                WHERE JNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setString(2, jname);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, mat);
			result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//2번 기능 : JNAME을 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력 (getPerson)
    // RANK는 SUM내림차순으로 순위를 정함. (HINT : LOWNUM과 INLINE 이용
	public ArrayList<Person> getPerson(String jname) {
		ArrayList<Person> person = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK , A.*"
				+ "    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "                                FROM PERSON P, JOB J"
				+ "                                WHERE P.JNO = J.JNO "
				+ "                                AND JNAME = ?"
				+ "                                ORDER BY SUM DESC) A ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				person.add(new Person(rank, pname, jname, sum, kor, eng, mat));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return person;
	}
	// 3번 기능 : RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력 (getPersonAll)
	public ArrayList<Person> getPerson(){
		ArrayList<Person> person = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*"
				+ "    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "                FROM PERSON P, JOB J"
				+ "                WHERE P.JNO = J.JNO "
				+ "                 ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				person.add(new Person(rank, pname, jname, sum, kor, eng, mat))	;	
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return person;
	}
}
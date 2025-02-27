package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Member;

public class Memberdao {
	public static final int SUCCESS = 1; // final 상수
	public static final int FAIL = 0;
	public static final int MEMBER_EXISTENT = 1; // 중복된 id일 경우
	public static final int MEMBER_NONEXISTENT = 0; // 사용가능한 id
	private DataSource ds;
	// 싱글톤 코드
	private static Memberdao INSTANCE ;
	public static Memberdao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Memberdao();
		}
		return INSTANCE;
	}
	private Memberdao() { // 생성자 함수에서 ds에 커넥션 풀을 가르키도록
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 회원목록
	 public ArrayList<Member> getMemberList(){
		 ArrayList<Member> members = new ArrayList<Member>();
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="SELECT *"
		 		+ "    FROM MEMBER"
		 		+ "    ORDER BY NAME";
		 try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw").replaceAll("[0-9a-zA-Z~`!@#$%^&*()]", "*"); // abc ***로
				String name = rs.getString("name");
				Date birth = rs.getDate("birth");
				Timestamp rdate = rs.getTimestamp("rdate");
				members.add(new Member(id, pw, name, birth, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 return members;
	 }
	// 2. id 중복체크
	 public int getCountMember(String id) {
		 int count = MEMBER_EXISTENT;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="SELECT COUNT(*)"
		 		+ "    FROM MEMBER"
		 		+ "    WHERE ID = ? ";
		 try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1); // 결과값이 1 아니면 0이라 1
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 return count;
	 }
	// 3. 회원가입
	 public int insertMember(Member member) { // 많아지면 dto로   
		 int result = FAIL;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql="INSERT INTO MEMBER (ID, PW, NAME, BIRTH)"
		 		+ "    VALUES (?, ?, ?, ?)";
		 try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setDate(4, member.getBirth());
			pstmt.executeUpdate(); // sql문 전송
			result = SUCCESS;
			System.out.println("회원 가입 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "회원가입 실패");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 return result;
	 }
}

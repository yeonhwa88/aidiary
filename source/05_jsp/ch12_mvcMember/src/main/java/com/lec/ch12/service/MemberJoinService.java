package com.lec.ch12.service;

import java.sql.Date;

import com.lec.ch12.dao.MemberRepository;
import com.lec.ch12.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터(id, pw, name, birth)받아 dao를 통해 id중복체크 후 join수행후 결과를 request에 set
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");
		// 스트링을 숫자형으로 integer.parseInt(); null,"","a" 안됨 
		// 스트링을 Date형으로 Date.valueOf("2001-12-12")
		Date birth = null;
		if(!birthStr.equals("")) { // 회원가입시 생년월일을 입력한 경우
			birth = Date.valueOf(birthStr);
		}
		Member newMember = new Member(id, pw, name, birth, null); // 객체를 받음
		MemberRepository repository = MemberRepository.getInstance();
		if(repository.getCountMember(id) == MemberRepository.MEMBER_NONEXISTENT) { // static final 클레스이름. 으로 불러와야됨 id중복확인
			int insertResult = repository.insertMember(newMember); // 회원가입
			request.setAttribute("insertResult", insertResult); // 1.방법
			if(insertResult == MemberRepository.SUCCESS) { // 2. 방법
				request.setAttribute("insertMsg", "가입성공");
			}else {
				request.setAttribute("insertMsg", "가입실패");
			}
		}else {
			
		}
	}

}

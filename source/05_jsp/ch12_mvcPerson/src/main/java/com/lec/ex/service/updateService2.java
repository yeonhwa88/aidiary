package com.lec.ex.service;

import java.sql.Date;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updateService2 implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// id, name, tel, address, birth, memo 중 빈스트링이 아닌 값만 수정
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo= request.getParameter("memo");
		// id로 person정보를 가져옴 -> 빈스트링파라미터가 아닌 값만 person에 setter로 값을 수정 => update
		PersonRepository dao = PersonRepository.getInstance();
		Person person = dao.getPerson(id); // 수정전 person 정보
		if(!name.equals("")) { // 수정할 이름을 받았을 경우
			person.setName(name);
		}
		if (!tel.equals("")){ // 수정할 전화번호를 받았을 경우
			person.setTel(tel);
		}
		if(!address.equals(address)){
			person.setAddress(address);
		}
		person.setBirth(birth); // 생일은 무조건 바꾸는 경우로 내용이 상시 있음
		if(!memo.equals("")) { // 수정할 메모를 받았을 경우
			person.setMemo(memo);
		}
		//if문 후에는 person에 수정할 정보가 담김
		int result = dao.updatePerson(person);
		System.out.println(result==PersonRepository.SUCCESS? "수정2 성공": "수정2 실패");
	}

}

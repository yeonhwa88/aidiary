package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// delete 로직
		System.out.println("delete할 정보 파라미터로 받아 dao 호출 결과 request에 setAttribute");
		request.setAttribute("deleteResult", 1);

	}

}

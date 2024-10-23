package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
@WebServlet("/ex2") // @ 어노테이션(Annotation)  class위에 
public class Ex2params extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
		actionDo(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//복수개의 menu, rest 파라미터, 1개의 gender 파라미터
		String gender = request.getParameter("gender"); // 같은 이름의 파라미터가 없을때
		String[] menu = request.getParameterValues("menu"); // 같은 이름의 파라미터가 있을때
		String[] rest = request.getParameterValues("rest"); // 같은 이름의 파라미터가 있을때
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림생성
		if(menu!=null) {
			out.println("<h2>선택한 메뉴는");
			for(String m : menu) {
				out.println(m + " ");
			}
			out.println("입니다 <h2>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다</h2>");
		}
		//out.println("<h2>선택한 메뉴는 " + Arrays.toString(menu) + "입니다</h2>"); //자바 배열 출력 Arrays.toString
		out.println("<h2>선택한 식당은 " + Arrays.toString(rest) + "입니다</h2>"); //자바 배열 출력 Arrays.toString
		String genderOut = gender==null ? "-" : gender.equals("m") ? "남자" : "여자";
		out.println("<h2>성별은 " + genderOut + "입니다</h2>");
		out.close();
	}

}

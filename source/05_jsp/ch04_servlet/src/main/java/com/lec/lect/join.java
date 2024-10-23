package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hidden = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mail = request.getParameterValues("mailSend");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2> hiddenParam : " + hidden + "</h2>");
		out.println("<h2> 이름 :" + name + "</h2>");
		out.println("<h2> 아이디 :" + id + "</h2>");
		out.println("<h2> 비밀번호 : ");
			for(int i=0; i<pw.length(); i++) {
				out.println("*");
		}
		out.println("</h2>");
		out.println("<h2> 생일 :" + birth + "</h2>");
		String genderout = gender==null ? "-" : gender.equals("m") ? "남자" : "여자";
		out.println("<h2> 성별 :" + genderout + "</h2>");
		out.println("<h2> 이메일 :" + email + "</h2>");
		out.println("<h2>메일수신동의 : ");
			if(mail!=null) {
				for(String m : mail) {
					out.println(m + " " );
		}
		out.println("</h2>");
		}else {
			out.println("이메일을 입력해주세요");
		}
	}
}

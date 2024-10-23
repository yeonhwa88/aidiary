package com.lec.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/HelloWorld")
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8090/ch03~/HelloWorld Get방식으로 요청하면 실행되는 부분
		// client > request(파라미터) 요청처리객체 전달 > 전달받아 실행될 함수 작성
		//		< response(html이나 응답처리객체를 담아서 전달) <
		System.out.println("Get 방식으로 요청");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post방식으로 요청하면 실행되는 부분
		System.out.println("Post방식으로 요청");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저 화면에 <h1>안녕하세요 첫 Servlet예제 입니다</h1>가 있는 html보냄
		response.setContentType("text/html;charset=UTF-8"); // 한글이 깨지지않게 선언
		PrintWriter out = response.getWriter(); // 스트림(빨대) 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/ex.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫 servlet예제 입니다.</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}

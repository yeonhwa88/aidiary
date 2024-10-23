package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GuGudan")
public class Quiz1GuGudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(su!=null) {
			for(String s : su) {
				int ssu = Integer.parseInt(s);
				for(int i=1; i<=9; i++) {
					out.println(ssu+"단"+ "*" + i + "는" + (ssu*i)+"<br>");
				}
			}//for
		}else
			out.println("<h2> 선택된 구구단이 없습니다 </h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}

	private void actiondo(HttpServletRequest request, HttpServletResponse response) {
		actiondo(request, response);
	}

}

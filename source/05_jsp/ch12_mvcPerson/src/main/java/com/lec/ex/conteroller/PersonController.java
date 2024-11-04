package com.lec.ex.conteroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lec.ex.service.DeleteService;
import com.lec.ex.service.InsertService;
import com.lec.ex.service.ListService;
import com.lec.ex.service.Service;
import com.lec.ex.service.UdateService;
import com.lec.ex.service.infoService;
import com.lec.ex.service.updateService2;

public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String conPath = request.getContextPath();
    	String command = uri.substring(conPath.length());
    	Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
    	String viewPage = null;
    	if(command.equals("/list.do")) {
    		service = new ListService();
    		service.execute(request, response);
    		viewPage = "person/list.jsp";
    	} else if(command.equals("/info.do")){
    		service = new infoService();
    		service.execute(request, response);
    		viewPage = "person/info.jsp";
    	} else if(command.equals("/insert.do")) {
    		viewPage = "person/insert.jsp";
    	} else if(command.equals("/delete.do")) {
    		service = new DeleteService();
    		service.execute(request, response);
    		viewPage = "list.do";
    	} else if(command.equals("/update.do")) {
    		service = new infoService();
    		service.execute(request, response);
    		viewPage = "person/update.jsp"; // person내용이 input의 value값
    	} else if(command.equals("/update2.do")) {
    		service = new infoService();
    		service.execute(request, response);
    		viewPage = "person/update2.jsp"; // person내용이 input의 placeholder값 
    	}
    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    	dispatcher.forward(request, response);    		
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	String uri = request.getRequestURI();
        	String conPath = request.getContextPath();
        	String command = uri.substring(conPath.length());
        	Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
        	String viewPage = null;
        	if(command.equals("/list.do")) {
        		service = new ListService();
        		service.execute(request, response);
        		viewPage = "person/list.jsp";
        	} else if(command.equals("/insert.do")) {
        		service = new InsertService();
        		service.execute(request, response);
        		viewPage = "list.do";
        	} else if (command.equals("/update.do")) {
        		service = new UdateService();
        		service.execute(request, response);
        		viewPage = "info.do";
        	} else if(command.equals("/info.do")){
        		service = new infoService();
        		service.execute(request, response);
        		viewPage = "person/info.jsp";
        	} else if(command.equals("/update2.do")) {
        		service = new updateService2();
        		service.execute(request, response);
        		viewPage = "info.do";
        	}
        	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        	dispatcher.forward(request, response);    		
    }
}

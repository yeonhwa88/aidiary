<%@page import="com.lec.dao.Memberdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<%
		String id = request.getParameter("id");
		Memberdao dao = Memberdao.getInstance();
		int cnt = dao.getCountMember(id);
		if(cnt == Memberdao.MEMBER_EXISTENT){
			out.print(" <b>중복된 ID입니다 </b>");
		}else {
			out.print("사용가능한 ID입니다");
		}
	%>
</body>
</html>
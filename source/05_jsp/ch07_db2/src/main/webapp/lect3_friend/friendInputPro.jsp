<%@page import="com.lec.dao.friendRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href ="<%=conPath %>/css/ex.css" rel="stylesheet"> 
</head>
<body>
	<%
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		friendRepository dao = friendRepository.getInstance();
		int result = dao.insertFriend(name, tel);
		if(result == friendRepository.SUCCESS){
	%>
		<script>
			alert("친구추가성공");
			location.href = "friendInputList.jsp"; //새롭게 request 요청
		</script>
	<% 
		}else{
	%>
		<script>
			alert("친구추가실패");
			location.href = "friendInputList.jsp"; // 이전페이지로 (방금 입력한 값이 그대로 보임)
		</script>
	<%
		}
	%>
</body>
</html>
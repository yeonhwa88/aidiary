<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 결과화면 </h2>
	<% 
	String name = request.getParameter("name"); // request.getParamete는 login화면에서 입력한 name=name name=id name=pw을 갖고온다
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	%>
	<h2>아이디는 <%=id %>이고</h2>
	<h2>비밀번호는 <%=pw %>입니다</h2>
	<h2><%=name %>님 감사합니다</h2>

</body>
</html>
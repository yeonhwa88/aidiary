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
	<h1>회원정보 (2_dispatchar폴더 파일) : request에 setAttribute한 내용</h1>
	<h2>ID ${member.id }(member.getid()를자동호출)</h2>
	<h2>PW ${member.pw }</h2>
	<h2>NAME${member.name }</h2>
	<hr>
	<h1>회원정보 : request의 파라미터 내용</h1>
	<h2>ID ${param.id }</h2>
	<h2>PW ${param.pw }</h2>
	<h2>NAME ${param.name }</h2>
</body>
</html>
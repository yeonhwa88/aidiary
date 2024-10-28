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
	<h2> ID : ${param.id }</h2> <!-- parameter 대신 param으로 사용 -->
	<h2> PW : ${param.pw }</h2>
	<h2> request의 requestAtt ${requestAtt }</h2>
</body>
</html>
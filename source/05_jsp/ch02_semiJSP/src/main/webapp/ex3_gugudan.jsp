<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>3단 구구단</h2>
	<%-- 스크립트릿을 닫아 그안에 태그를 쓸수 있도록 만들어 태그를 사용 --%>
	<%for(int i=1; i<=9; i++){%>
		<p>3 * <%=i %> = <%=3*i %></p>
	<%}%>
</body>
</html>
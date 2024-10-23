<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이 파일은 ex1_hello.jsp입니다</h1>
	<h4>JSP파일은 html안에 java가 들어있는 파일</h4>
	<h5>cf. 서블릿파일(브라우저에서 실행이 할수있는 java파일)은 java안에 html에 들어있는 파일</h5>
	<%
		// 스크립트릿 내에서는 자바 코드
		int total = 0;
		for(int cnt=1; cnt<=100; cnt++){
			total += cnt;
		}
	%>
	<h2> 1부터 100까지 누적한 값은 <%=total %>입니다</h2> 
</body>
</html>
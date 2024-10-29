<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href ="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<!-- 1. ex6_gugudanResult.jsp 에서 정답/ 오답 출력 -->
	<!-- 2. ex7_gugudanQuiz.jsp 에서 정답/ 오답 출력 -->
	<form action="ex6_gugudanResult.jsp">
		<%-- 0<= Math.random()*9 <=9 0~9까지의 실수정수랜덤 발생 --%>
		<%-- (int)(Math.random()*9+1) 1~9까지의 정수랜덤발생 더하기 1을해야지만 1부터 시작 --%>
		<p>
			<%-- readonly 숫자가 생성된후 변경을 못한다 --%>
			<input type="text" name="n1" readonly="readonly" size="1" value="<%=(int)(Math.random()*9+1)%>">
			<b>*</b>
			<input type="text" name="n2" readonly="readonly" size="1" value="<%=(int)(Math.random()*9+1)%>">
			<b>=</b>
			<input type="number" name="result" placeholder="정답입력"> <!-- placeholder 도움말 -->
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
</body>
</html>
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
	<form action="ex6_gugudanResult.jsp">
		<p>
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
	<c:set var="n1" value="${param.n1 }"/>
	<c:set var="n2" value="${param.n2 }"/>
	<c:set var="result" value="${param.result }"/>
	<c:if test="${n1*n2 eq result }">
		<h3>${n1 } <b>*</b> ${n2 }<b>=</b>${result } <b>정답입니다</b></h3>
	</c:if>
	<c:if test="${not(n1*n2 eq result) && not empty result}">
		<h3>${n1 } <b>*</b> ${n2 }<b>=</b>${result } <b>오답입니다</b></h3>
	</c:if>
	<c:if test="${empty result }"/>
</body>
</html>
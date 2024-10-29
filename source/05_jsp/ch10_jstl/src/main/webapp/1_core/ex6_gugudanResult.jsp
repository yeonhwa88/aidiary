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
	<c:set var="n1" value="${param.n1 }"/>
	<c:set var="n2" value="${param.n2 }"/>
	<c:set var="result" value="${param.result }"/>
	<c:if test="${n1*n2 eq result}">
		<h3> ${n1 } <b>*</b> ${n2 } <b>=</b> ${result } 정답입니다</h3>
	</c:if>
	<c:if test="${not(nu1*nu2 eq result)}">
		<h3> ${n1 } <b>*</b> ${n2 } <b>=</b> ${result } 오답입니다</h3>
	</c:if>
</body>
</html>
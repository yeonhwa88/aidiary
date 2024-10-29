<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href ="${conPath }/css/ex.css" rel="stylesheet">
</head>
<body>
	conPath(/context root) : ${conPath }<br>
	<%-- date타입은 날짜와 시간을 다 저장 --%>
	<%-- import는 똑같은이름의 class는 두번 할수없다 같은 Date (sql, util) --%>
	<c:set var="nowSqlDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>" />
	<c:set var="nowUtilDate" value="<%=new java.util.Date() %>"/>
	${nowSqlDate }<br>
	${nowTimes}<br>
	${nowUtilDate }<br>
	<h3>날짜만 출력</h3>
	short: <fmt:formatDate value="${nowTimes }" type="date" dateStyle="short"/> <br>
	medium: <fmt:formatDate value="${nowTimes }" type="date" dateStyle="medium"/> <br>
	long: <fmt:formatDate value="${nowTimes }" type="date" dateStyle="long"/> <br>
	full: <fmt:formatDate value="${nowTimes }" type="date" dateStyle="full"/> <br>
	<h3>시간만 출력</h3>
	short: <fmt:formatDate value="${nowSqlDate }" type="time" timeStyle="short"/><br>
	medium: <fmt:formatDate value="${nowSqlDate }" type="time" timeStyle="medium"/><br>
	long: <fmt:formatDate value="${nowSqlDate }" type="time" timeStyle="long"/><br>
	full: <fmt:formatDate value="${nowSqlDate }" type="time" timeStyle="full"/><br>
	<h3>날짜와 시간을 모두출력</h3>
	<fmt:formatDate value="${nowUtilDate }" type="both" dateStyle="long" timeStyle="medium"/><br>
	<fmt:formatDate value="${nowUtilDate }" pattern="YY-MM-dd(E) HH:mm:ss:SSS"/><br>
	<fmt:formatDate value="${nowUtilDate }" pattern="YY-MM-dd(E) a hh:mm:ss"/><br>
</body>
</html>
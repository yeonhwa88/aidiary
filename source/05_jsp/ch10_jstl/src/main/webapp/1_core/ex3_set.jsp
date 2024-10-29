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
	<h3> 변수 선언하고 출력과 삭제 </h3>
	<c:set var="varName" value="varValue" scope="page"/> <!-- 변수선언 scope 생략시 page 들어감 이페이지만 유효함 -->
	varName : ${varName } <br>
	<c:set var="varName" value="xxxx"/>
	varName : ${varName } <br>
	<%-- varName 변수 삭제 --%>
	<c:remove var="varName"/>
	varName(삭제한 후 변수 ) : ${varName } <br>
	varName(삭제한 후 변수 ) : <c:out  value="${varName }" default="삭제된 변수"/><br>
	varName(삭제한 후 변수 ) : ${empty varName ? "삭제된 변수" : varName } <br>
</body>
</html>
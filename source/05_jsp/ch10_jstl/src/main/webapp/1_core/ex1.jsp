<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- if, for태그 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--  날짜태그,숫자태그 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- 펑션태그 -->
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href ="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<%-- JSP 표준 액션 태그에서의 include : jsp를 실행한 결과를 html을 include --%>
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
	<h2>core 라이브러리 태그 : if, forEach, set, ... </h2>
	<%
		for(int i=0; i<=3; i++){
			out.print(i+ "번째 안녕하세요<br>");
		}
	%>
	<c:forEach var="i" begin="1" end="3" step="1">
		${i } 번째 안녕하세요 <br>
	</c:forEach>
	<h2>fmt(formatting)라이브러리 : 날짜나 숫자 format	</h2>
	<fmt:formatDate value="<%=new Date(System.currentTimeMillis()) %>" pattern="YY-MM-dd(E)"/><%--sql로 import 했을시 --%>
	<fmt:formatNumber value="356356.356" pattern="#,###.##"/> <%--jsp태그에선 /로 닫는태그를 대체할수 있다 --%>
	<h2>그외 라이브러리(function) : el표기법과 함께 사용</h2>
	id 파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
	id 파라미터를 대문자로 : ${param.id.toUpperCase() }
</body>
</html>
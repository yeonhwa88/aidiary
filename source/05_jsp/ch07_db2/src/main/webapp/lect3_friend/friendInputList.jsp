<%@page import="com.lec.dto.friend"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.friendRepository"%>
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
	<form action="friendInputPro.jsp" method="post">
		<p>
			친구이름
			<input type="text" name="name" required="required" size="5">
			전화
			<input type="text" name="tel" size="10">
			<input type="submit" value="추가">
		</P>
	</form>
	<table>
		<tr>
			<td>순번</td>
			<td>이름</td>
			<td>전화</td>
		</tr>
		<%
			friendRepository repository = friendRepository.getInstance();
			ArrayList<friend> friendList = repository.getfriendList();
			for(friend friend : friendList){
				String tel = friend.getTel(); // null일 수도 있는 전화번호
				out.println("<tr>");
				out.println("<td>"+ friend.getNo() + "</td>");
				out.println("<td>"+ friend.getName() + "</td>");
				out.println("<td>"+ (tel==null?"":tel) + "</td>");
			}
		%>
	</table>
</body>
</html>
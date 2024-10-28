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
	<%
		String name = request.getParameter("name");
		//String pets = request.getParameter("pets"); 첫번째것만 가져옴 배열을 가져올수없음
		String[] pets = request.getParameterValues("pets");
		if(pets ==null){
			//////
		}
	%>
	<h3> 이름 ${param.name }</h3>
	<h3>
		키우는 동물
		${paramValues.pets[0] } <%-- null이면 무시 빈스트링으로 출력 --%>
		${paramValues.pets[1] } 
		${paramValues.pets[2] } 
		${paramValues.pets[3] } 
		${empty paramValues.pets ? "없습니다":"" } <%-- null 인지 물어보는 empty --%>	
	</h3>
</body>
</html>
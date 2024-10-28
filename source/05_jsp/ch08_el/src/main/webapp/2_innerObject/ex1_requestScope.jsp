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
	<form action="ex2_requestScope.jsp">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p> <input type="submit"> </p>
	</form>
	<%
		// request중 requestAtt라는 속성을 만들고 그안에 requestValue가 들어감 request(메소드중하나 attribute속성변수)
		request.setAttribute("requestAtt", "requestValue"); // ★ 새로운 요청이 들어오기 전까지 유효
		// 자바에서 request객체에서 setAttribute한 내용을 jsp로 전달
		// request객체를 유지한 상태에서 페이지 변경 (forward)
		RequestDispatcher dispatcher 
				= request.getRequestDispatcher("ex2_requestScope.jsp?id=aaa&pw=111");
		// 입력하는 창 없이 내용이 넘어가라고 만드는것 바로출력
		dispatcher.forward(request, response); // 페이지 넘어감
	%>
	<h2><%=request.getAttribute("requestAtt") %></h2>
	<h2>${requestScope.requestAtt }</h2>
	<h2>${requestAtt }</h2> <!-- 자동으로 requestValue가 출력 -->
</body>
</html>
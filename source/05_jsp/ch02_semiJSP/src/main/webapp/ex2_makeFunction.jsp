<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% //스크립트릿은 자바 코드
		long result = power(2, 10);
	%>
		<!--  표현식에서는 power(9, 10)등의 식을 넣어서 작성할수있음 -->
		<p>2의 10승은<%=result %>입니다</p>
		<p>9의 10승은 <%=power(9, 10) %>입니다 </p>
	<%!// 선언부는 먼저  최초 1회 실행
		private long power(int a, int b){ // power : a의 b승을 return 
		long result = 1;
		for(int i=1; i<=b; i++){
			result *= a; // result = result*a;
		}//for
		return result;
	}
	%>
</body>
</html>
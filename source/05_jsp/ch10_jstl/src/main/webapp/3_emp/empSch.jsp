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
	<form action="${conPath}/empSch">
		<p> 
			이름 <input type="text" name="schName" value="${empty param.schName? "": param.schName.toUpperCase().trim() }">
			직책 <input type="text" name="schJob" value="${empty param.schJob? "":  param.schJob.toUpperCase().trim()}">
			<input type="submit" value="검색">
		</p>
	</form>
		<table>
			<tr>
				<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>
			</tr>
			<c:forEach var="emp" items="${empSch }">
				<tr>
					<td>${emp.empno }</td> <!-- el표기법에서 emp.empno는 emp.getEmpno() -->
					<td>
						<c:if test="${emp.sal >= 3000 }">
							<img src="${conPath }/img/hot.gif" alt="hot">
						</c:if> 
						<c:if test="${empty emp.mgr }">
							<b style="color:red">${emp.ename }</b>
						</c:if>
						<c:if test="${not empty emp.mgr }">
							${emp.ename }
						</c:if>
					</td>
					<td> ${emp.job } </td>
					<td> ${empty emp.mgr ? "CEO":emp.mgr} </td>
					<td> 
						<fmt:formatDate value="${emp.hiredate }" pattern ="yyyy년 MM월dd일(E)"/>
					</td>
					<td>
						<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/> <!-- groupingUsed 소수점은 관여하지않고 3자리마다 ,출력 -->
					</td>
					<td>
						<fmt:formatNumber value="${emp.comm }" pattern="##,###.#"/> <!-- 0아니면 # 0으로 하면 반드시 그자리수만큼 출력 -->
					</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	String name = request.getParameter("name");
	if(name!=null && !name.equals("")){
		name = name.trim();
	}else if(name == null){
		name = "";
	}
	int su1 = 0;
	int sum = 0;
	String su = request.getParameter("su");
	if(su!=null && !su.equals("")	){
		su1 = Integer.parseInt(su);	
		for(int i=1; i<=su1; i++){
			sum += i;
		}
	}else if(su==null){
		su = "";
	}
	%>
	<form>
		<fieldset>
			<legend>입력</legend>
				<p>이름 <input type="text" name="name" value="<%=name==null ? "" : name.trim()%>"> </p>
				<p>숫자 <input type="number" name="su" value="<%=su%>"></p>	
				<p><input type="submit" value="누적"></p>
		</fieldset>		
	</form>
	<% 
		if(!su.equals("")){
		out.print("<h2> 1부터" + su1 + "누적합은" + sum + "입니다");	
		}
	%>						
	</body>
</html>
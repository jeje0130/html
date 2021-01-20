<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	p{
		font-size : 1.5em;
		background : skyblue;
	}
</style>

</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String res = "";
	String items[] = request.getParameterValues("sel2");
	for(String item : items){
		res += item + " ";
	}
	
%>

<h3>선택하신 브랜드입니다</h3>
<p><%= res %></p>

</body>
</html>
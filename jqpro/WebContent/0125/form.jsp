<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	p{
		font-size: 5.0 em;
		color: red;
	
	}
	
</style>
</head>
<body>
	<h1>JSP : Java Server Page</h1>
	
<%
	String a = request.getParameter("txt");
	String b = request.getParameter("pass");
%>

<p><%= a %></p>	
<p><%= b %></p>	
</body>
</html>
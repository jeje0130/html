<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	p{
		font-size : 1.2em;
		background : pink;
		margin : 20px 30px;
	}
</style>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8"); //맨위에 써줘야댐

	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	String userGender = request.getParameter("gender");
	
	String foods[] = request.getParameterValues("food");
	String file = request.getParameter("file");
	
	String fod = "";
	for(int i =0; i<foods.length; i++){
		fod += foods[i] + "&nbsp;&nbsp; ";
	}
	
	
%>

<p> <%= userId %> </p> 
<p> <%= userName %> </p>
<p> <%= userGender %> </p>
<p> <%= fod %> </p>
<p> <%= file %></p>

</body>
</html>
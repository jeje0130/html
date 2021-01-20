<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> JSP : JAVA Server page</h1>
<%
	request.setCharacterEncoding("UTF-8"); /* post일때 한글쓰면 깨지기 때문에 utf-8로 설정해야됨  */

	String inputName = request.getParameter("name");
	String inputId = request.getParameter("id");

%>

	<%= inputName %>님 환영합니다  <br>  
	<%= inputId %>님 즐거운 하루보내세요  <br>

</body>
</html>
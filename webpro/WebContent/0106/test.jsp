<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 JSP파일입니다</h1>
	<h3>JSP : JAVA Server page의 약자입니다</h3>
	<h4>html태그 안에 java 코딩이 가능한 페이지입니다.</h4>
	
	<%
	 //여긴 자바 코드 작성하는 곳 
	 //클라이언트가 전송시 입력 데이터를 받는다
	 //request라는 내장 객체를 이용한다
	 
     request.setCharacterEncoding("UTF-8"); //맨위에 써줘야댐
	
	 String userName = request.getParameter("name");
	 String userId = request.getParameter("id");
	 String userTel = request.getParameter("tel");
	 
	 //db연결
	 //sql문 수행(select)
	 //sql 수행결과 출력
	%>
	
	<%= userName %> 님 환영합니다 <br>  
	<%= userId %> 님 즐거운 하루 되세요 <br>
	<%= userTel %> 번호로 연락드립니다 <br>
</body>
</html>
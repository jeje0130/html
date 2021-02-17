<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 실행된 결과값가져오기
	int num = (Integer)request.getAttribute("abc");

	if(num > 0){
%>
	{
		"sw" : "성공"
	}

		
<%	}else{ %>
	
	{
		"sw" : "실패"
	}


<%
	}
%>
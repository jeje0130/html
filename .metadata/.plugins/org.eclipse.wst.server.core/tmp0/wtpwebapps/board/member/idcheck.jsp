<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 request에 저장된 값을 가져온다
	String a = (String)request.getAttribute("abc");
	if(a != null){
		//id가 이미 있다 - 사용 불가능
%>
{
	"sw" : "사용 불가능한 아이디입니다. "
}

<%
	}else{
		//id가 없다 -사용가능
%>
{
	"sw" : "사용 가능한 아이디입니다. "
}

<%
	}
%>
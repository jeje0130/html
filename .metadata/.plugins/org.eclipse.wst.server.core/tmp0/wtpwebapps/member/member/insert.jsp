<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 request에 저장된 값을 가져온다
	String a = (String)request.getAttribute("abc");
	if(a != null){
%>
{
	"b" : "회원가입 성공입니다. "
}

<%
	}else{
%>
{
	"b" : "회원가입 실패입니다. "
}

<%
	}
%>
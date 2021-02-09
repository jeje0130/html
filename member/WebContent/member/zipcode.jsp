<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 request에 저장된 값을 가져온다
	List<ZipVO> list = (List<ZipVO>)request.getAttribute("abc");
%>
[
<%
	for(int i=0; i<list.size(); i++){
		ZipVO vo = list.get(i);
		
		String bunji = vo.getBunji();
		if(bunji == null) bunji = ""; //bunji가 null일 경우 빈칸으로 변경
		
		if(i>0) out.print(",");
%>	
{
	"code" : "<%= vo.getZipcode() %>",
	"addr" : "<%= vo.getSido() %> <%= vo.getGugun() %> <%= vo.getDong() %>",
	"bunji" : "<%= bunji %>"
}

<% 		
	}
%>

]
<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
[
<%
	//서블릿에서 실행된 결과값가져오기
	List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("abc");

	for(int i =0; i<list.size(); i++){
		ReplyVO vo = list.get(i);
		if(i>0) out.print(",");
%>

	{
	"renum" : "<%=vo.getRenum() %>",
	"bonum" : "<%=vo.getBonum() %>",
	"cont" : "<%= vo.getCont().replaceAll("\r","").replaceAll("\n", "<br>")%>",
	"name" : "<%= vo.getName() %>",
	"redate" : "<%= vo.getRedate() %>"	
	}


<%
}
%>

]
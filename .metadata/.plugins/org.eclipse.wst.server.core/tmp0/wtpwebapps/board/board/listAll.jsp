<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
	<%
	//servlet에서 최종결과를 받아서 출력
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("abc");

	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(",");
	
	%>
	
		{
			"num" : "<%= vo.getNum() %>",
			"subject" : "<%= vo.getSubject() %>",
			"writer" : "<%= vo.getWriter() %>",
			"mail" : "<%= vo.getMail() %>",
			"pass" : "<%= vo.getPassword() %>",
			"cont" : "<%= vo.getContent() %>",
			"hit" : "<%= vo.getHit() %>",
			"date" : "<%= vo.getWdate() %>"
		}
	
	
	<% 	
	}
	%>
]

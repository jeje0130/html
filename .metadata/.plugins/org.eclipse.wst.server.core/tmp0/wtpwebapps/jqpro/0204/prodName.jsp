<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.ProdVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//클라이언트 요청시 전송되는 데이타 받기
	String lgu = request.getParameter("gu");

	// SqlMapClient객체를  얻어오기 
	SqlMapClient client = SqlMapClientFactory.getClient();

	// SQL문 실행 
	List<ProdVO> list = client.queryForList("prod.selectByName", lgu);	
	if(list != null && list.size() > 0) {
%>
{
	"sw" : "ok",
	"datas" : 

[
<%
 for(int i=0; i<list.size(); i++){
	ProdVO vo = list.get(i);
	if(i>0) out.print(",");
%>

{
	"id" : "<%= vo.getProd_id() %>",
	"name" : "<%= vo.getProd_name() %>"
}

<%
 }
%>

]
}

<%
	}else{
%>
	
{	"sw" : "no" }	
	
	
		
<%		
	}
%>
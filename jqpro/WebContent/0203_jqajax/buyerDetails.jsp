<%@page import="kr.or.ddit.buyer.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 클라이언트 요청시 전송되는 데이타 받기
	String buyer_id = request.getParameter("id");

	// SqlMapClient객체를  얻어오기 
	SqlMapClient client = SqlMapClientFactory.getClient();

	// SQL문 실행 
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.selectByDetails", buyer_id); //결과 1줄만 받아오기
%>

{
	"ID" : "<%= vo.getBuyer_id() %>",
	"NAME" : "<%= vo.getBuyer_name() %>",
	"LGU" : "<%= vo.getBuyer_lgu()%>",
	"BANK" : "<%= vo.getBuyer_bank()%>",
	"BANKNO" : "<%= vo.getBuyer_bankno()%>",
	"BANKNAME" : "<%= vo.getBuyer_bankname()%>",
	"ZIP" : "<%= vo.getBuyer_zip()%>",
	"ADD1" : "<%= vo.getBuyer_add1()%>",
	"ADD2" : "<%= vo.getBuyer_add2()%>",
	"COMTEL" : "<%= vo.getBuyer_comtel()%>",
	"FAX" : "<%= vo.getBuyer_fax()%>",
	"MAIL" : "<%= vo.getBuyer_mail()%>",
	"CHARGER" : "<%= vo.getBuyer_charger()%>",
	"TELEXT" : "<%= vo.getBuyer_telext()%>"
}
<%@page import="kr.or.ddit.buyer.BuyerVO"%>
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


			<table class='tab'>
				<tr><td>BUYER_ID</td>
				<td> <%= vo.getBuyer_id() %> </td></tr>
				
				<tr><td>BUYER_NAME</td>
				<td> <%= vo.getBuyer_name() %> </td></tr>
				
				<tr><td>BUYER_LGU</td>
				<td> <%= vo.getBuyer_lgu() %> </td></tr>
				
				<tr><td>BUYER_BANK</td>
				<td> <%= vo.getBuyer_bank() %> </td></tr>
				
				<tr><td>BUYER_BANKNO</td>
				<td> <%= vo.getBuyer_bankno() %> </td></tr>
				
				<tr><td>BUYER_BANKNAME</td>
				<td> <%= vo.getBuyer_bankname() %> </td></tr>
				
				<tr><td>BUYER_ADD1</td>
				<td> <%= vo.getBuyer_add1() %> </td></tr>
				
				<tr><td>BUYER_ADD2</td>
				<td> <%= vo.getBuyer_add2() %> </td></tr>
				
			</table>
				
				
				
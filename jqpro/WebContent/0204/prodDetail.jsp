<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.prod.ProdVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//클라이언트 요청시 전송되는 데이타 받기
	String id = request.getParameter("id");

	// SqlMapClient객체를  얻어오기 
	SqlMapClient client = SqlMapClientFactory.getClient();

	// SQL문 실행 
	ProdVO vo = (ProdVO)client.queryForObject("prod.selectByDetalis", id);	

%>

			<table class="table table-striped" border="1">
				<tr><td>항목</td>
				<td>내용</td></tr>
			
				<tr><td>PROD_ID</td>
				<td> <%= vo.getProd_id()%> </td></tr>
				
				<tr><td>PROD_NAME</td>
				<td> <%= vo.getProd_name() %> </td></tr>
				
				<tr><td>PROD_LGU</td>
				<td> <%= vo.getProd_lgu() %> </td></tr>
				
				<tr><td>PROD_BUYER</td>
				<td> <%= vo.getProd_buyer() %> </td></tr>
				
				<tr><td>PROD_COST</td>
				<td> <%= vo.getProd_cost() %> </td></tr>
				
				<tr><td>PROD_PRICE</td>
				<td> <%= vo.getProd_price() %> </td></tr>
				
				<tr><td>PROD_SALE</td>
				<td> <%= vo.getProd_sale() %> </td></tr>
				
				<tr><td>PROD_OUTLINE</td>
				<td> <%= vo.getProd_outline() %> </td></tr>
				
				<tr><td>PROD_DETAIL</td>
				<td> <%= vo.getProd_detail() %> </td></tr>
				
			</table>
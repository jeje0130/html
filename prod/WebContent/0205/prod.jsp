<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

List<ProdVO> list = (List<ProdVO>)request.getAttribute("abc");

%>

<table border="1">

	<tr>
		<td>Prod_id</td>
		<td>Prod_name</td>
		<td>Prod_lgu</td>
		<td>Prod_price</td>
	</tr>
<%
for(int i=0; i<list.size(); i++){
	ProdVO vo = list.get(i);
%>

	<tr>
		<td><%= vo.getProd_id() %></td>
		<td><%= vo.getProd_name()%></td>
		<td><%= vo.getProd_lgu()%></td>
		<td><%= vo.getProd_price()%></td>
	</tr>

	
<%
}
%>


</table>
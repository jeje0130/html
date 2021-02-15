<%@page import="kr.or.ddit.lprod.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1.SqlMapClient객체를  얻어오기 - 
	SqlMapClient a = SqlMapClientFactory.getClient();

	//2.SQL문을 실행 - mapper에 있는 namespace.id 이름
	List<LprodVO> list = a.queryForList("lprod.selectLprod");
%>

<table border="1">
	<tr class="tr1">
		<td>lprod_id</td>
		<td>lprod_gu</td>
		<td>lprod_nm</td>
	</tr>

<% 
	//3.실행 결과로 json데이터 생성 - java와 json 분리
	for(int i=0; i<list.size(); i++){
		LprodVO vo = list.get(i);
		//if(i > 0) out.print(",");
%>

	<tr>
		<td><%= vo.getLprod_id() %></td>
		<td><%= vo.getLprod_gu() %></td>
		<td><%= vo.getLprod_nm() %></td>
	</tr>


<% } %>

</table>
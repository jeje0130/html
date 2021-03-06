<%@page import="kr.or.ddit.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClientBuilder"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="com.ibatis.common.resources.Resources"%>
<%@page import="java.io.Reader"%>
<%@page import="com.ibatis.common.io.ReaderInputStream"%>
<%@page import="java.nio.charset.Charset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
	//클라이언트 요청시 전송되는 데이터를 받는다
	//CRUD 처리를 한다.
	// 1.SqlMapClient객체를  얻어오기 - a = SqlMapClientFactory.getClient()
	// 2.SQL문을 실행 - mapper에 있는 namespace.id 이름
	// select ==> a.queryForList(namespace.id 이름) - 결과 여러줄
	// select ==> a.queryForObject(namespace,  id 이름) - 결과 1줄
	
	//처리 결과로 응답 데이터를 생성한다. - json, text, html, xml
	
%>

<%
	//1.SqlMapClient객체를  얻어오기 - 
	SqlMapClient a = SqlMapClientFactory.getClient();

	//2.SQL문을 실행 - mapper에 있는 namespace.id 이름
	List<MemberVO> list = a.queryForList("member.selectAll");
%>


[


<% 
	//3.실행 결과로 json데이터 생성 - java와 json 분리
	for(int i=0; i<list.size(); i++){
		MemberVO vo = list.get(i);
		if(i > 0) out.print(",");
		%>


{
	"id"   : "<%= vo.getMem_id() %>",
	"name" : "<%= vo.getMem_name() %>",
	"hp"   : "<%= vo.getMem_hp() %>",
	"mail" : "<%= vo.getMem_mail() %>"
}

<%		
	}
%>



]













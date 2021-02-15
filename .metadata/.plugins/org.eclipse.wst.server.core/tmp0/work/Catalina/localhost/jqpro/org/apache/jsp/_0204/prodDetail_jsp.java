/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.107
 * Generated at: 2021-02-15 00:41:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._0204;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.prod.ProdVO;

public final class prodDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


	//클라이언트 요청시 전송되는 데이타 받기
	String id = request.getParameter("id");

	// SqlMapClient객체를  얻어오기 
	SqlMapClient client = SqlMapClientFactory.getClient();

	// SQL문 실행 
	ProdVO vo = (ProdVO)client.queryForObject("prod.selectByDetalis", id);	


      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table table-striped\" border=\"1\">\r\n");
      out.write("\t\t\t\t<tr><td>항목</td>\r\n");
      out.write("\t\t\t\t<td>내용</td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_ID</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_id());
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_NAME</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_name() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_LGU</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_lgu() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_BUYER</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_buyer() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_COST</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_cost() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_PRICE</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_price() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_SALE</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_sale() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_OUTLINE</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_outline() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr><td>PROD_DETAIL</td>\r\n");
      out.write("\t\t\t\t<td> ");
      out.print( vo.getProd_detail() );
      out.write(" </td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

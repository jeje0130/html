package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class DongSearch
 */
@WebServlet("/DongSearch.do")
public class DongSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DongSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 전송되는 값을 리턴
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
				
		//2. service 객체 얻기
		IMemberService service = MemberServiceImpl.getService();
				
		//3. service 메서드 호출 - 결과값 받기
		List<ZipVO> list = service.selectByDong(dong);

		//4. 결과값을 request에 저장 - session(세션이 종료되기 전까지 사용-로그인), application(서버가 꺼지기 전까지 사용), request(jsp에서 사용 후 끝남) 
		request.setAttribute("abc", list);  
				
		//5. view페이지로(jsp) forward한다.
		RequestDispatcher disp = request.getRequestDispatcher("member/zipcode.jsp");
				
		disp.forward(request, response);
	}

}

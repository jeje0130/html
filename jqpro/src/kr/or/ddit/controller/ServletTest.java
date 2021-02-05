package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.MemberVO;
import kr.or.ddit.service.IServiceSample;
import kr.or.ddit.service.ServiceImpl;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 클라이언트 요청시 전송되는 데이타 받기
		String a = request.getParameter("id");
		
		// 2. CRUD 처리 준비
		// 2-1. service 객체 생성(얻어오기 - servlet은 new가 아니라 get) 
		IServiceSample service = ServiceImpl.getService();
		
		// 3. service 메서드 호출 - 결과값 리턴 받아 가져오기
		List<MemberVO> list = service.getMemberAll();
		
		// 4. list 결과값을 request객체에 저장
		request.setAttribute("abc", list); //키값은 아무거나 get할때 필요!
		
		// 5. 수행된 결과값을 view페이지로 보낸다 - forward방식
		RequestDispatcher disp = request.getRequestDispatcher("0205/view.jsp");
		
		disp.forward(request, response);
		
		
	}

}

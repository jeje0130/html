package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceIpml;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시 전송되는 데이타 받기
		
				
		// 2. CRUD 처리 준비
		// 2-1. service 객체 생성(얻어오기 - servlet은 new가 아니라 get) 
		ILprodService service = LprodServiceIpml.getService();
				
		// 3. service 메서드 호출 - 결과값 리턴 받아 가져오기
		List<LprodVO> list = service.selectLprod();
				
		// 4. list 결과값을 request객체에 저장
		request.setAttribute("abc", list); //키값은 아무거나 get할때 필요!
				
		// 5. 수행된 결과값을 view페이지로 보낸다 - forward방식
		RequestDispatcher disp = request.getRequestDispatcher("0205/lprod.jsp");
				
		disp.forward(request, response);
	}

}

package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 글번호 가져온다
		int num = Integer.parseInt(request.getParameter("num"));
		
		//2. service 객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		//3. service 메서드 호출 - 결과값 받기
		int cnt = service.deleteBoard(num);
		
		//4. 결과값을 request에 저장 
		request.setAttribute("abc", cnt);
		
		//5. view페이지로(jsp) forward한다.
		RequestDispatcher disp = request.getRequestDispatcher("board/result.jsp");
		
		disp.forward(request, response);
	
	}

}

package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

@WebServlet("/ListReply.do")
public class ListReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListReply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 클라이언트 요청시 전송되는 값을 리턴 - bonum값 받기
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//2. service 객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		//3. service 메서드 호출 - 결과값 받기
		List<ReplyVO> list = service.listReply(bonum);
		
		//4. 결과값을 request에 저장 
		request.setAttribute("abc", list);
		
		//5. view페이지로(jsp) forward - replyList.jsp한다.
		RequestDispatcher disp = request.getRequestDispatcher("board/replyList.jsp");
		disp.forward(request, response);
	}

}

package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/Insert.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 전송되는 값을 리턴
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String pass = request.getParameter("mem_pass");
		String hp = request.getParameter("mem_hp");
		String mail = request.getParameter("mem_mail");
		String bir = request.getParameter("mem_bir");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		
		// 1-1.VO에 저장
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_name(name);
		vo.setMem_pass(pass);
		vo.setMem_hp(hp);
		vo.setMem_mail(mail);
		vo.setMem_bir(bir);
		vo.setMem_zip(zip);
		vo.setMem_add1(add1);
		vo.setMem_add2(add2);
		*/
						
		//2. service 객체 얻기
		IMemberService service = MemberServiceImpl.getService();
						
		//3. service 메서드 호출 - 결과값 받기
		String member = service.insertMember(vo);

		//4. 결과값을 request에 저장 - session(세션이 종료되기 전까지 사용-로그인), application(서버가 꺼지기 전까지 사용), request(jsp에서 사용 후 끝남) 
		request.setAttribute("abc", member);  
						
		//5. view페이지로(jsp) forward한다.
		RequestDispatcher disp = request.getRequestDispatcher("member/insert.jsp");
						
		disp.forward(request, response);
	}

}

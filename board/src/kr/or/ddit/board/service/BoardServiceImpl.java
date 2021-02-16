package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

/*
 * Dao객체 얻어오기 - 생성자
 * Dao 메서드 호출하기 - 결과값 리턴받기
 * servlet으로 리턴한다
 * 
 * servlet에서 사용할 자신의 객체 생성
 * 자신의 객체를 리턴하는 getService()메서드 정의
 * 
 */

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService(){
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}

	@Override
	public List<BoardVO> selectAll() {
		
		List <BoardVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> selectBypage(Map<String, Integer> map) {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectBypage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public int listCount() {
		
		int cnt = 0;
		
		try {
			cnt = dao.listCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}


	

}

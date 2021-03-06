package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

/*
 * Dao객체 얻어오기 - 생성자
 * Dao 메서드 호출하기 - 결과값 리턴받기
 * servlet으로 리턴한다
 * 
 * servlet에서 사용할 자신의 객체 생성
 * 자신의 객체를 리턴하는 getService()메서드 정의
 * 
 */

public class ProdServiceImpl implements IProdService {
	
	private IProdDao dao;
	private static IProdService service;
	
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService(){
		if(service == null) service = new ProdServiceImpl();
		
		return service;
	}

	@Override
	public List<ProdVO> selectProd() {
		
		List<ProdVO> list = null;
		list = dao.selectProd();
		
		return list;
	}

}

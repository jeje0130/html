package kr.or.ddit.lprod.sevice;

import java.util.List;


import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoIpml;
import kr.or.ddit.lprod.vo.LprodVO;

/*
 * Dao객체 얻어오기 - 생성자
 * Dao 메서드 호출하기 - 결과값 리턴받기
 * servlet으로 리턴한다
 * 
 * servlet에서 사용할 자신의 객체 생성
 * 자신의 객체를 리턴하는 getService()메서드 정의
 * 
 */

public class LprodServiceIpml implements ILprodService {

	private ILprodDao dao;
	private static ILprodService service;
	
	private LprodServiceIpml(){
		dao = LprodDaoIpml.getDao();
	}
	
	public static ILprodService getService(){
		if(service == null) service = new LprodServiceIpml();
		
		return service;
	}
	
	
	@Override
	public List<LprodVO> selectLprod() {
		List<LprodVO> list =null;
		
		//dao메서드 호출하여 결과값을 받기	
		list = dao.selectLprod();
		
		return list; //servlet으로 리턴
	}

}

package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
 * Dao객체 얻어오기 - 생성자
 * Dao 메서드 호출하기 - 결과값 리턴받기
 * servlet으로 리턴한다
 * 
 * servlet에서 사용할 자신의 객체 생성
 * 자신의 객체를 리턴하는 getService()메서드 정의
 * 
 */

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl(){
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService(){
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public String selectById(String id) {
		String resId = null;
		
		//dao에서 수행된 결과를 받음
		try {
			resId = dao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resId; //controller로 리턴
	}

	@Override
	public String insertMember(MemberVO vo) {
		String inputId = null;
		
		try {
			inputId = dao.insertMember(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> list = null;
		
		try {
			list = dao.selectByDong(dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

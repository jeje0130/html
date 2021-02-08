package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;



public interface IMemberDao {

	//메서드 선언
		//id 중복체크
		public String selectById(String id) throws SQLException;
		
		//저장 - 회원가입제출
		public String insertMember(MemberVO vo) throws SQLException;
		
		//우편번호찾기
		public List<ZipVO> selectByDong(String dong) throws SQLException;
}

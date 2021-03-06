package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;


public interface IMemberService {
	
	//메서드 선언
	//id 중복체크
	public String selectById(String id);
	
	//저장 - 회원가입제출
	public String insertMember(MemberVO vo);
	
	//우편번호찾기
	public List<ZipVO> selectByDong(String dong);

}

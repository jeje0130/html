package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	//전체 목록 가져오기
	public List<BoardVO> selectAll() throws SQLException;
		
	//페이지별 목록 가져오기
		
	//게시글 저장하기
		
	//게시글 수정하기
		
	//게시글 삭제하기
		
	//댓글 저장하기
		
	//댓글 수정하기
		
	//댓글 삭제하기
		
	//조회수 증가
		
	//전체글 갯수 가져오기
}
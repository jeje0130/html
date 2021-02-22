package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

/*
 * sqlMapClient 객체 얻기 - 생성자
 * mapper - sql문을 실행하기 위한 객체
 * 
 * 자신의 객체를 생성해서 리턴 - getDao() getInstance()
 * - service에서 사용하기 위해 
 */
public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient client;
	private static IBoardDao dao;
	
	private BoardDaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static IBoardDao getDao(){
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}

	@Override
	public List<BoardVO> selectAll() throws SQLException {
		
		return client.queryForList("board.selectAll");
		
		/*List<BoardVO> list = null;
		
		list = client.queryForList("board.selectAll");
		
		return list;*/
	}

	@Override
	public List<BoardVO> selectBypage(Map<String, Integer> map)
			throws SQLException {
		return client.queryForList("board.selectBypage", map);
	}
	
	
	@Override
	public int listCount() throws SQLException {
		return (int) client.queryForObject("board.listCount");
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (int) client.insert("board.insertBoard", vo);
	}

	@Override
	public int deleteBoard(int num) throws SQLException {
		return client.delete("board.deleteBoard", num);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		return client.update("board.updateBoard", vo);
	}

	@Override
	public int updateHit(int num) throws SQLException {
		return client.update("board.updateHit", num);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (Integer) client.insert("reply.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		return client.queryForList("reply.listReply", bonum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		return client.update("reply.updateReply", vo);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		return client.delete("reply.deleteReply", renum);
	}


	

}

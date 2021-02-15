package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
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

}

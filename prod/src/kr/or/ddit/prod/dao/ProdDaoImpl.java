package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

/*
 * sqlMapClient 객체 얻기
 * mapper실행하기
 * 실행결과를 service로 리턴
 * 
 * service에서 사용될 자신의 객체를 생성하기
 * 자신의 객체를 리턴하기
 */

public class ProdDaoImpl implements IProdDao {
	
	
	private SqlMapClient client;
	private static IProdDao dao;
	
	private ProdDaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static IProdDao getDao(){
		if(dao == null) dao = new ProdDaoImpl();
		
		return dao;
	}
	

	@Override
	public List<ProdVO> selectProd() {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

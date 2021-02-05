package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;
/*
 * sqlMapClient 객체 얻기
 * mapper실행하기
 * 실행결과를 service로 리턴
 * 
 * service에서 사용될 자신의 객체를 생성하기
 * 자신의 객체를 리턴하기
 */
public class LprodDaoIpml implements ILprodDao {

	
	private SqlMapClient client;
	private static ILprodDao dao;
	
	private LprodDaoIpml(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static ILprodDao getDao(){
		if(dao == null) dao = new LprodDaoIpml();
		
		return dao;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		List<LprodVO> list =null;
		
		try {
			list = client.queryForList("lprod.selectLprod");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}

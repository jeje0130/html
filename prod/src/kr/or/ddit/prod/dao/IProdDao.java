package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;


public interface IProdDao {
	//메서드 선언
		public List<ProdVO> selectProd();
}

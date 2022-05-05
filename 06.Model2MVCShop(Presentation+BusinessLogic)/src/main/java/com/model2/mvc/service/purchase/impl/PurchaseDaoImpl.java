package com.model2.mvc.service.purchase.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDAO;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDAO {

	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void seqSqlsession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void addPurchase(Purchase purchase) throws Exception{
		sqlSession.insert("PurchaseMapper.addPurchase",purchase);
	}
	
	public Purchase findPurchase(int tranNo) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.findPurchase",tranNo);
	}
	
	public List<Purchase> getPurchaseList(Search search, String buyerId) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("buyerId", buyerId);
		map.put("endRowNum", search.getEndRowNum()+"");
		map.put("startRowNum", search.getStartRowNum()+"");
		return sqlSession.selectList("PurchaseMapper.getPurchaseList",map);
		
//		List<Object> list = new ArrayList<Object>();
//		list.add(search);
//		list.add(buyerId);
//		return sqlSession.selectList("PurchaseMapper.getPurchaseList",list);
	}
	
	public void updatePurchase(Purchase purchase) throws Exception{
		sqlSession.update("PurchaseMapper.updatePurchase",purchase);
	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updateTranCode",purchase);
	}
	
	public int getTotalCount(Search search) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.getTotalCount",search);
	}

}

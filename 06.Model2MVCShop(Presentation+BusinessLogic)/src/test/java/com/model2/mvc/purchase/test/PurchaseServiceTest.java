package com.model2.mvc.purchase.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(locations = {"classpath:config/commonservice.xml"})
@ContextConfiguration(locations= {"classpath:config/context-aspect.xml",
								"classpath:config/context-common.xml",
								"classpath:config/context-mybatis.xml",
								"classpath:config/context-transaction.xml"})
public class PurchaseServiceTest {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	//ok
	//@Test
	public void testAddPurchase() throws Exception{
		User user = new User();
		Product product = new Product();
		Purchase purchase = new Purchase();
		
		user.setUserId("user01");
		product.setProdNo(10020);
		purchase.setReceiverName("test01");
		purchase.setReceiverPhone("9090909");
		purchase.setDivyAddr("강남");
		purchase.setDivyRequest("문");
		
		
		System.out.println(purchase);
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchaseService.addPurchase(purchase);
		System.out.println("sql add 완료");
		
		purchase = purchaseService.findPurchase(10000);
		System.out.println(purchase);
		
		Assert.assertEquals("user01", purchase.getBuyer());
		Assert.assertEquals("9090909", purchase.getReceiverPhone());
		Assert.assertEquals("강남", purchase.getDivyAddr());
		Assert.assertEquals("문", purchase.getDivyRequest());
	}
	
	//ok
	//@Test
	public void testGetPurchase() throws Exception{
		Purchase purchase = new Purchase();
		
		purchase = purchaseService.findPurchase(10000);
		System.out.println(purchase);
		System.out.println("find 완료");
	}
	
	//ok
	//@Test
	public void testUpdatePurchase() throws Exception{
//		Purchase purchase = purchaseService.findPurchase(10008);
//		Assert.assertNotNull(purchase);
//		Assert.assertEquals("user01", purchase.getBuyer());
//		Assert.assertEquals("test01",purchase.getReceiverName());
		
		User user = new User();
		Product product = new Product();
		Purchase purchase = new Purchase();
//		Purchase purchase = new Purchase();
		user.setUserId("testUserUpdate");
		product.setProdNo(10009);
		purchase.setBuyer(user);
		purchase.setPurchaseProd(product);
		purchase.setTranNo(10008);
		purchase.setReceiverName("testtest01");
		purchase.setDivyAddr("미국");
		purchaseService.updatePurchase(purchase);
		System.out.println("TestUpdate완료");
		
	}
	
	//ok
	//@Test
	public void testGetPurchaseListAll() throws Exception{
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		Map<String,Object> map = purchaseService.getPurchaseList(search,"user20");
		
		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(3, list.size());
		
		System.out.println(list);
		
		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
		
		System.out.println("==================");
		
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("");
		
		list = (List<Object>)map.get("list");
		Assert.assertEquals(3, list.size());
		System.out.println(list);
		
		totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
	}
	
}

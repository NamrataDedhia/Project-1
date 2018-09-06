package com.niit.shopigobackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shopigobackend.dao.OrdersDAO;
import com.shop.shopigobackend.model.Orders;

public class OrdersDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	private static OrdersDAO orderDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		
		orderDAO = (OrdersDAO) context.getBean("orderDAO");
	}
	
	@Ignore
	@Test
	public void receipt()
	{
		Orders order = new Orders();
		order.setUsername("vicn");
		order.setPurchaseValue(2200);
		order.setPaymentMode("Cash");
		order.setOrderDate(new java.util.Date());
		
		boolean result = orderDAO.receiptGenerate(order);
		assertEquals("New Order", true, result);
		
	}
}

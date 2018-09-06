package com.niit.shopigobackend.testcases;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shopigobackend.dao.CartDAO;
import com.shop.shopigobackend.model.Cart;



public class CartDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addtoCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(1);
		cart.setProductName("Levis Jeans");
		cart.setQuantity(1);
		cart.setPrice(2200);
		cart.setUsername("vicn");
		cart.setStatus("NA");
		
		assertTrue("Problem in adding Cart",cartDAO.addToCart(cart));
	}

	

	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart=cartDAO.getCartItem(2); // put the correct Cartid from DB
		cart.setQuantity(2);
		assertTrue("Problem in Updating",cartDAO.updateCart(cart));
	}
	
	@Ignore
	@Test
	public void deletefromCartTest()
	{
		Cart cart=cartDAO.getCartItem(2);
		assertTrue("Problem in Deleting:",cartDAO.deleteFromCart(cart));
	}
	
	
	/*@Test
	public void listCartItemsTest()
	{
		List<Cart> listCartItems=cartDAO.listCartItems
		assertNotNull("Problem in Retrieving:",listCartItems);
	}
*/
}


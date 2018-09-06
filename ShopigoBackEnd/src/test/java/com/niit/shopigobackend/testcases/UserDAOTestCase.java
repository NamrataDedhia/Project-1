package com.niit.shopigobackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shopigobackend.dao.UserDAO;
import com.shop.shopigobackend.model.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void saveUserTestCase()
	{
		User user = new User();
		user.setUsername("Adm");
		user.setPassword("adm@995");
		user.setRole("admin");
		user.setCustomerName("adest");
		user.setMobileNo("8954948659");
		user.setEmailId("adm@xyz.com");
		user.setAddress("Dubai");
		
		
		assertTrue("Problem in Saving User", userDAO.save(user));
	}
	
	@Ignore
	@Test
	public void deleteUserTestCase()
	{
		boolean actual = userDAO.delete("asd");
		assertEquals("Delete User", true, actual);
	}
	@Ignore
	@Test
	public void getParticularUsers()
	{
		int size = userDAO.list("user").size();
		assertEquals(2, size);
	}

}
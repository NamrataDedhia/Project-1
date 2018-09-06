package com.niit.shopigobackend.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shopigobackend.dao.ProductDAO;
import com.shop.shopigobackend.model.Product;


public class ProductDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Ignore
		@Test
		public void addProductTest()
		{
			Product product=new Product();
			product.setProductName("Levis Jeans");
			product.setProdDesc("Slim,Fit for all!");
			product.setPrice(2200);
			product.setStock(12);
			product.setCategoryId(1);
			
			assertTrue("Problem in Adding Product",productDAO.addProduct(product));
		}
		

		@Ignore
		@Test
		public void deleteProductTest()
		{
			Product product=productDAO.getProduct(2);
			assertTrue("Problem in Deleting:",productDAO.deleteProduct(product));
		}
		
		@Test
		public void listProductsTest()
		{
			List<Product> listProducts=productDAO.listProducts();
			assertNotNull("Problem in Retrieving:",listProducts);
		}
		
	
}

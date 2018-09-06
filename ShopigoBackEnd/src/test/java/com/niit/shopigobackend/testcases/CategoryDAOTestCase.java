package com.niit.shopigobackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.shopigobackend.dao.CategoryDAO;
import com.shop.shopigobackend.model.Category;


public class CategoryDAOTestCase 
{

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Sports,Books & More!");
		category.setCategoryDesc("Variants available");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	
	
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(6);
		assertTrue("Problem in Deleting:",categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategoryDetails()
	{
		Category category = categoryDAO.getCategory(1);
		String name = category.getCategoryName();
		assertEquals("Apparels", name);
	}

}
package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.testbase.TestBase;

public class AmazonHomePageTest extends TestBase{
	
	public AmazonHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void pageLander() {
		init();
	}
	
	@AfterMethod
	public void closeTest() {
		tearDown();
	}
	
	//First Test
	@Test
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "Assertion Failed : Title not matched");
	}
}

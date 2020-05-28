package com.qa.elementstestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.base.TestBase;
import com.qa.pages.ElementsPage;
import com.qa.util.TestUtil;


public class TestCases_T01 extends TestBase {
	ElementsPage elementsPage;
	Logger log = Logger.getLogger(TestCases_T01.class);
	
	public TestCases_T01() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		elementsPage= new ElementsPage();
		
	}
	
	
	@Test
	public void textBoxTestCase(){
		log.info("**********************starting the test case***************");
		elementsPage.selectCard("Elements");
		elementsPage.selectItem("Text Box");
		elementsPage.enterUserDetails("Abhishek", "Testuser1@gmail.com", "Baker Street N01011");
		
		Assert.assertEquals("ToolsQA", TestUtil.getPageTitle());
		
		
		log.info("**********************Ending the test case***************");
	}
	
	

}

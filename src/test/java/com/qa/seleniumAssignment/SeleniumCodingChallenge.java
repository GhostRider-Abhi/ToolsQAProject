package com.qa.seleniumAssignment;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.SeleniumChallenge;


/*1) go to this url -https://www.zoopla.co.uk/
2) Input location London and click submit
3) You will get a list of properties on that page. 
4) Print all the price values in sorted order (descending order) on the console
5) I need to select the 5th property on that list (its changing every minute, so it�s dynamic) 
6) On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent�s page.
7) Once on that page, I need to check that the the properties listed there belong to the same mentioned agent on the page.
*/

public class SeleniumCodingChallenge extends TestBase {
	String Url="https://www.zoopla.co.uk/";
	SeleniumChallenge page;
	
	 public SeleniumCodingChallenge() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization(Url);
		page = new SeleniumChallenge();

		
	}
	
	@Test
	public void ZooplaTest()  {
		page.searchPropertyFor("London");
		page.getAllPrices();
		page.selectpropertyAt(5);
		
		String listedpropertyName= page.getPropertyName();
		System.out.println(listedpropertyName);
		page.clickOnListedAgent();
		Assert.assertTrue(page.confirmPropertyOnAgentsPage(listedpropertyName));
		
	}
	

}

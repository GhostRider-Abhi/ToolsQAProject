package com.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class SeleniumChallenge extends TestBase {

	public SeleniumChallenge() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "[type='submit']~[data-responsibility='acceptAll']")
	WebElement cookie;

	@FindBy(id = "search-input-location")
	WebElement inputsearch;

	@FindBy(id = "search-submit")
	WebElement searchBtn;

	@FindBy(css = ".css-1e28vvi-PriceContainer .css-18tfumg-Text")
	List<WebElement> propertyPrices;
	
	@FindBy(css = "[data-testid='listing-details-link']")
	List<WebElement> listingDetails;
	
	@FindBy(xpath = "//article/h2")
	WebElement propertyName;
	
	@FindBy(xpath = "//div[@class='ui-agent__text']/h4")
	WebElement agentName;
	
	@FindBy(css = ".listing-results-right >span>a")
	List<WebElement> propertiesOnAgentPage;
	

	// Getting all values for the given loaction and sorting them in descendng
	// order- using collection

	public void searchPropertyFor(String city) {
		cookie.click();
		inputsearch.sendKeys(city);
		searchBtn.click();
	}

	public void getAllPrices() {

		ArrayList<String> arrlist = new ArrayList<String>();
		for (WebElement prop : propertyPrices) {
			arrlist.add(prop.getText());
		}
		Collections.sort(arrlist); 
		Collections.reverse(arrlist);
		System.out.println(arrlist);
		
	}
	
	public void selectpropertyAt(int num) {
		TestUtil.scrollIntoView(propertyPrices.get(num));
		
		//WebElement prop =propertyPrices.get(num).findElement(By.cssSelector("[data-testid='listing-details-link']"));
		listingDetails.get(5).click();
		//prop.click();
	}
	public String getPropertyName() {
		return propertyName.getText();
	}
	
	public void clickOnListedAgent() {
		agentName.click();
	}
	
	public boolean confirmPropertyOnAgentsPage(String listedProperty) {
		ArrayList<String> arrlist = new ArrayList<String>();
		for (WebElement lstprop : propertiesOnAgentPage) {
			arrlist.add(lstprop.getText());
		}
		return arrlist.contains(listedProperty);
		
	}
	

}

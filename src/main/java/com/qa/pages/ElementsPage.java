package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ElementsPage  extends TestBase{
	
	public ElementsPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
	WebElement card;
	
	@FindBy(id ="userName")
	WebElement userName;
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="currentAddress")
	WebElement currentAddress;
	
	@FindBy(id="submit")
	WebElement submitButton;
	//--------------------------------------------------Actions---------------------------------------------------------
	
	public void selectCard(String Cardname) {
		//Thread.sleep(5000);
		WebElement card= driver.findElement(By.xpath("//h5[text()='"+Cardname+"']"));
		TestUtil.scrollIntoView(card);
		card.click();
	}
	public void selectItem(String Itemname) {
		WebElement item = driver.findElement(By.xpath("//span[@class='text'][text()='"+Itemname+"']"));
		TestUtil.scrollIntoView(item);
		item.click();
	}
	
	
	public void enterUserDetails(String username , String email, String address) {
		userName.sendKeys(username);
		userEmail.sendKeys(email);
		currentAddress.sendKeys(address);
		TestUtil.scrollIntoView(submitButton);
		submitButton.click();
		
	}

}

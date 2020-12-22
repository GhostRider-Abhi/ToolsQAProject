package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ElementsPage  extends TestBase{
	
	
	public ElementsPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	Actions act= new Actions(driver);
	
	
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
	
	@FindBy(css = ".rct-icon-expand-all")
	WebElement expand_chkbox;
	
	@FindBy(xpath="//div[@id='result']/span")
	List<WebElement> selectedItemsfromCheckbox;
	
	
	//*******************WebTables identifiers*************************
	@FindBy(css= "[role=\"columnheader\"] div[class=\"rt-resizable-header-content\"]")
	List<WebElement> columnName;
	
	@FindBy(css = "[role=\"rowgroup\"] [role=\"row\"] ")
	List<WebElement> rownumber;
	
	@FindBy(xpath = "//div[@role=\"gridcell\"][contains(text(),'@')]/parent::div")
	List<WebElement> rowcount;
	
	
	@FindBy(id = "eM9Ux")
	WebElement clickButton;
	
	@FindBy(id = "rightClickBtn")
	WebElement rightclickButton;
	
	@FindBy(id = "doubleClickBtn")
	WebElement doubleclickButton;
	
	
	@FindBy(xpath = "//div[@id='linkWrapper']//a")
	List<WebElement> links;
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
	
	
	//*********************CheckBox action******************************
	public void expandCheckBox() {
		expand_chkbox.click();
	}
	
	public String getSelectedItems(int i) {
		
		return selectedItemsfromCheckbox.get(i+1).getText();
		
	}
	
	//*********************Webtables action******************************
	//This method will get all the data value for the respective refernce value like insurance
	public List<WebElement> getDatawithRespectTo(String reference) {
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='rt-td'][@role=\"gridcell\"][text()='"+reference+"']/parent::div/div"));
		return data;
	}
	
	/*public List<WebElement> getDatawithRespectTotry(String reference) {
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='rt-td'][@role=\"gridcell\"][text()='"+reference+"']/parent::div/div"));
		//data.get(0).getText();
		String name= data.get(0).getText();
		String lastname= data.get(1).getText();
		
		return new List<WebElement>(name,lastname);
		

	}
    */
	public void printColumn() {
		for (int i=0;i<columnName.size();i++) {
			System.out.print("|| "+columnName.get(i).getText());
		}
		
	}
	public void printrowValue(int row) {
		printColumn();
		System.out.println("");
		List<WebElement> values= rownumber.get(row).findElements(By.cssSelector("div"));
		for(int i=0;i<values.size();i++) {
			System.out.print("|| "+values.get(i).getText());
		}
	}
	public int getRowCount() {
		return rowcount.size();
		
	}
	//******************Button Action**********************88
	public void rightClick() {
		act.contextClick(rightclickButton).perform();;
	}
	public void doubleClick() {
		act.doubleClick(doubleclickButton).perform();;
	}
	//*********************Links************************
	
	public int getLinksCount() {
		return links.size();
	}
	public void getUrlsOfLinksAvailable() {
		for(WebElement lnk:links) {
			System.out.println("Link for "+lnk.getText()+" is ="+ lnk.getAttribute("href"));
			
		}
	}
	
	
	
	
}

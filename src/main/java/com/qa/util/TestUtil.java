package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	public static String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static String PageSource() {
		return driver.getPageSource();
	}
	
	public static void scrollIntoView(WebElement ele) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
}



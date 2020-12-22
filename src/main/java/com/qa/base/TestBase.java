package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import com.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static Logger log = Logger.getLogger(TestBase.class);
	public static String userDirectory = System.getProperty("user.dir");

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(userDirectory + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
			log.info("Config File is loaded");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			log.info("**********************Starting the tes Execution****************");
			System.setProperty("webdriver.chrome.driver",
					userDirectory + "/src/main/java/com/qa/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("launching the chrome driver");
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/admin/Documents/SeleniumServer/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		log.info("launching the application url");
	}
	
	//@overload
	public static void initialization(String Url) {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			log.info("**********************Starting the tes Execution****************");
			System.setProperty("webdriver.chrome.driver",
					userDirectory + "/src/main/java/com/qa/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("launching the chrome driver");
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/admin/Documents/SeleniumServer/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(Url);
		log.info("launching the application url");
	}

	public void selectByText(String text) {
		WebElement txt = driver.findElement(By.xpath("//span[text()='" + text + "']"));
		txt.click();

		// span[text()='Angular']
	}

	public int getHTTPresponse(URL url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			int response = connection.getResponseCode();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return e.hashCode();
		}

	}

}

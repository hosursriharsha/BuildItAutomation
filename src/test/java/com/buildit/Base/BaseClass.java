package com.buildit.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * This is the base class for this project
 * 
 * @author H Sri Harsha
 *
 */
public class BaseClass {

	protected static WebDriver driver;

	/**
	 * This method creates driver instance. Currently by default, it launches in
	 * chrome
	 */
	@BeforeTest(alwaysRun = true)
	public void createDriverInstance() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/**
	 * This method returns the value of any property
	 * 
	 * @param key
	 *            contains the reference of the key which requires corresponding
	 *            value
	 * @return string which is a value of key passed
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected String getValue(String key) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	/**
	 * This method finds the element with given locator
	 * @param locator contains the reference of the id or xpath or any other
	 * @return WebElement contains the reference of the element
	 */
	protected WebElement findElement(String locator) {
		WebElement element=null;
		if (locator.contains("id=")) {
			locator=locator.split("=")[1];
			element= driver.findElement(By.id(locator));
		}
		return element;
	}
	
	/**
	 * This method launches the given URl
	 * @param URL contains the url to be launched
	 */
	protected void launchURL(String URL) {
		driver.get(URL);
	}
	
	/**
	 * This method quits the browser
	 */
	@AfterTest
	protected void quitBrowser() {
		driver.quit();
	}
}

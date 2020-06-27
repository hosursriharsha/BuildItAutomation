package com.buildit.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.buildit.locators.locators;

import io.cucumber.java.en.Then;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import com.buildit.Base.BaseClass;

/**
 * This class has all the methods related to weather forecast
 * @author H Sri Harsha
 *
 */
public class WeatherForecastPage extends BaseClass {

	/**
	 * This method launches URL
	 */
	public void launchURL() {
		launchURL(getValue("urlToLaunch"));
		assertTrue(findElement(locators.cityLabel).isDisplayed(), "URL is not launched");
	}

	/**
	 * This method gets city name
	 * @return
	 */
	public String getInitialCityName() {
		return findElement(locators.cityLabel).getAttribute("value");
	}

	/**
	 * This method changes the city name
	 */
	public void changeCityName() {
		Actions action = new Actions(driver);
		action.doubleClick(findElement(locators.cityLabel)).sendKeys("Perth").sendKeys(Keys.ENTER).perform();
	}
}

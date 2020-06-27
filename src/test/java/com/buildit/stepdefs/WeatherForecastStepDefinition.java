package com.buildit.stepdefs;

import static org.testng.Assert.assertTrue;

import com.buildit.pages.WeatherForecastPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * This class contains all the methods related to weather forecast feature
 * 
 * @author H Sri Harsha
 *
 */
public class WeatherForecastStepDefinition {

	private WeatherForecastPage weatherForecastPage = new WeatherForecastPage();
	private String initialCityName;

	/**
	 * This class chooses the city
	 */
	@Given("user launches the url")
	public void launchURL() {
		weatherForecastPage.launchURL();
	}

	/**
	 * This method gets city name
	 */
	@When("user gets inital city name")
	public void getInitialCityName() {
		initialCityName = weatherForecastPage.getInitialCityName();
		System.out.println("################ initialCityName is : " + initialCityName);
	}

	/**
	 * This method changs city name
	 */
	@Then("user changes the city name")
	public void changeCityName() {
		weatherForecastPage.changeCityName();
	}
/**
 * This method verifies change in city name
 */
	@Then("user verifies the change in city name")
	public void verifyChangeInCityName() {
		String finalCityName = weatherForecastPage.getInitialCityName();
		System.out.println("################ finalCityName is : " + finalCityName);
		assertTrue(!(finalCityName.equalsIgnoreCase(initialCityName)), "City not changed");
	}
}

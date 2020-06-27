package com.buildit.Base;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This is the runner class for this project
 * @author H Sri Harsha
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", 
glue = "classpath:com.buildit.stepdefs")
public class Runner extends AbstractTestNGCucumberTests {

}

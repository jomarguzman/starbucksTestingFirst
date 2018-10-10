package com.automation.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.driver.MyDriver;
import com.automation.pages.StarbucksHomePage;

public class BaseTest {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		starbucksHome.dispose();
	}
	
	public StarbucksHomePage getStarbucksHomePage() {
		return starbucksHome;
	}
	
}

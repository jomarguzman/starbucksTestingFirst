package com.automation.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.driver.MyDriver;
import com.automation.pages.StarbucksHomePage;

public class BaseTest {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeTest(String browser) {
		myDriver = new MyDriver(browser);
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		starbucksHome.dispose();
	}
	
}

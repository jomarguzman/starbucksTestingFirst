package com.automation.tests;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.configurations.PropertyManager;
import com.automation.pages.StarbucksHomePage;

public class StarbucksTestFirst extends BaseTest{
	
	Logger logger = LoggerFactory.getLogger(StarbucksTestFirst.class);
	
	@Test( groups="firstTest")
	public void testStarbucksSearch(){
		
		logger.info("Running 1st Test");
		
		StarbucksHomePage home = new StarbucksHomePage(myDriver.getDriver());
		List<String> menuItems = home.menuOptions();
		List<String> optionsToCompare = Arrays.asList(new PropertyManager().getInstance().getMenuOptions().trim().split(","));
		
		Assert.assertEquals(menuItems, optionsToCompare);
		
	}
}

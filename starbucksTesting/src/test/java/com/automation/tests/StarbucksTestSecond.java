package com.automation.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.configurations.AnswerOption;
import com.automation.pages.FindCoffePage;
import com.automation.pages.StarbucksHomePage;

public class StarbucksTestSecond extends BaseTest{
	
	Logger logger = LoggerFactory.getLogger(StarbucksTestSecond.class);
	
	@Test(groups="secondTest", dataProvider="answerOption")
	public void testStarbucksSearch(AnswerOption answerOption){
		
		logger.info("Running 2nd Test");
		
		logger.info("Menu option testing: Data(" + answerOption + ")");
		StarbucksHomePage home = new StarbucksHomePage(myDriver.getDriver());
		FindCoffePage findPage = new FindCoffePage(myDriver.getDriver());
		
		home.menuCoffee();
		
		String currentURL = findPage.selectCoffee(answerOption);
		
		Assert.assertEquals(currentURL, "https://athome.starbucks.com/coffee-finder/");
	}
	
	@DataProvider(name="answerOption")
    public Object[][] getData() {
		return new Object[][]{{new AnswerOption(0)},{new AnswerOption(1)},{new AnswerOption(2)}};
	}
}

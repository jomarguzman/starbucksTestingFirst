package com.automation.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.configurations.PropertyManager;
import com.automation.pages.StarbucksHomePage;

public class StarbucksTest extends BaseTest{
	
	@Test
	public void testStarbucksSearch(){
		StarbucksHomePage home = getStarbucksHomePage();
		List<String> menuItems = home.menuOptions();
		List<String> optionsToCompare = Arrays.asList(new PropertyManager().getInstance().getMenuOptions().trim().split(","));
		
		Assert.assertEquals(menuItems, optionsToCompare);
		
	}
}

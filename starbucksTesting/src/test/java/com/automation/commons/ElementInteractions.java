package com.automation.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;

public class ElementInteractions extends BasePage{
	
	public ElementInteractions(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}
	
	public void clickOnMenu(WebElement menu) {
		getWait().until(ExpectedConditions.elementToBeClickable(menu));
		menu.click();
	}

}

package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.base.BasePage;
import com.automation.configurations.PropertyManager;

public class MyAccountPage extends BasePage{
	
	Logger logger = LoggerFactory.getLogger(MyAccountPage.class);
	
	public MyAccountPage(WebDriver pDriver) {
		super(pDriver);
		String baseURL = PropertyManager.getInstance().getURL();
		pDriver.get(baseURL);
	}

	@FindBy(css=".whiteSpace-truncate.flex-auto.sb-navbar-list")
	WebElement menuOptions;
	
	@FindBy(css=".absoluteSpread")
	WebElement gifOptions;
	
	@FindBy(id="recipientName")
	WebElement recipientName;
	
	@FindBy(id="recipientEmail")
	WebElement recipientEmail;
	
	@FindBy(tagName="form")
	WebElement formGift;
	
	public String selectGift(String name, String email) {
		
		WebElement option = findWebElement(menuOptions, "Gift");
		getWait().until(ExpectedConditions.elementToBeClickable(option));
		option.click();
		
		gifOptions.click();
		
		fillInput(recipientName, name);
		fillInput(recipientEmail, email);
		formGift.submit();
		
		getWaitSeconds(100);
		
		return getURL();
	}
	
	private void fillInput(WebElement input, String data) {
		input.sendKeys(data);
	}
	
	private WebElement findWebElement(WebElement parent, String value) {
		List<WebElement> options = menuOptions.findElements(By.tagName("li"));
		for (WebElement webElement : options) {
			if(webElement.getText().equalsIgnoreCase(value)) {
				logger.info("Element selected: {}", webElement.getText());
				return webElement;
			}
		}
		return null;
	}
	
}

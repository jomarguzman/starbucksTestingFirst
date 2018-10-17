package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;
import com.automation.configurations.PropertyManager;

public class MyAccountPage extends BasePage{
	
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
	
	@FindBy(css="visible")
	WebElement buttonContainer;
	
	public String selectGift(String name, String email) {
		WebElement option = findWebElement(menuOptions, "Gift");
		getWait().until(ExpectedConditions.elementToBeClickable(option));
		option.click();
		
		getWait().until(ExpectedConditions.elementToBeClickable(gifOptions));
		gifOptions.click();
		
		fillInput(recipientName, name);
		fillInput(recipientEmail, email);
		checkoutGift(buttonContainer);
		
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
				System.out.println(webElement.getText());
				return webElement;
			}
		}
		return null;
	}
	
	private void checkoutGift(WebElement container) {
		WebElement submit = container.findElement(By.tagName("button"));
		getWait().until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
	}
	
}

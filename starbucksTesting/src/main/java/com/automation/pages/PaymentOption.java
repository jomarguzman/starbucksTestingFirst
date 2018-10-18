package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.automation.base.BasePage;
import com.automation.configurations.PropertyManager;

public class PaymentOption extends BasePage{

	Logger logger = LoggerFactory.getLogger(PaymentOption.class);
	
	public PaymentOption(WebDriver pDriver) {
		super(pDriver);
		String baseURL = PropertyManager.getInstance().getURL();
		pDriver.get(baseURL);
	}
	
	@FindBy(id="paymentMethod")
	WebElement payment;
	
	@FindBy(xpath="/html/body/div/div/div/span/div/div/div/div/div/div/div/div/span/div/button")
	WebElement continueButton;
	
	@FindBy(tagName="form")
	WebElement paymentForm;
	
	public String pay() {
		logger.info("Payment option");
		
		selectElement(payment);
		
		getWait().until(ExpectedConditions.elementToBeClickable(continueButton));
		Assert.assertEquals(continueButton.getText(),"Continue");
		paymentForm.submit();
		
		logger.info("URL: {}",getURL());
		return getURL();
	}
	
	public void selectElement(WebElement select) {
		
		Select mySelect = new Select(select);
		mySelect.selectByValue("masterpass");
		
	}
}

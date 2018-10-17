package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;
import com.automation.configurations.PropertyManager;

public class AccountSigning extends BasePage {

	public AccountSigning(WebDriver pDriver) {
		super(pDriver);
		String baseURL = PropertyManager.getInstance().getURL();
		pDriver.get(baseURL);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement userPassword;
	
	@FindBy(css=".sb-frap")
	private WebElement signinButton;
	
	public String signIn(String userName, String userPassword) {
		this.userName.sendKeys(userName);
		this.userPassword.sendKeys(userPassword);
		getWait().until(ExpectedConditions.elementToBeClickable(signinButton));
		signinButton.sendKeys(Keys.ENTER);
		getWaitSeconds(10);
		return getURL();
	}
	
}

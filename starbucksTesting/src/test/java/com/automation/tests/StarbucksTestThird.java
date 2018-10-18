package com.automation.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.data.AccountDataProvider;
import com.automation.pages.AccountSigning;
import com.automation.pages.MyAccountPage;
import com.automation.pages.PaymentOption;
import com.automation.pages.StarbucksHomePage;

public class StarbucksTestThird extends BaseTest{
	
	Logger logger = LoggerFactory.getLogger(StarbucksTestThird.class);
	
	@Test ( groups="thirdTest", dataProvider = "userDataProvider", dataProviderClass = AccountDataProvider.class)
	public void testStarbucksLogin(String userName, String userPassword){
		
		StarbucksHomePage home = new StarbucksHomePage(myDriver.getDriver());
		AccountSigning loginPage = new AccountSigning(myDriver.getDriver());
		MyAccountPage myAccountPage = new MyAccountPage(myDriver.getDriver());
		PaymentOption paymentOption = new PaymentOption(myDriver.getDriver());
		
		home.navigateHomePage();
		loginPage.signIn(userName, userPassword);
		myAccountPage.selectGift("userName","mail@mymail.com");
		String currentURL = paymentOption.pay();
		Assert.assertEquals(currentURL, "https://app.starbucks.com/gift/873069716#payment");
	}
	
	@Test ( enabled = false, groups="thirdTest", dataProvider = "giftDataProvider", dataProviderClass = AccountDataProvider.class)
	public void testStarbucksSearch(String userName, String userPassword){
		MyAccountPage myAccountPage = new MyAccountPage(myDriver.getDriver());
		String currentURL = myAccountPage.selectGift(userName,userPassword);
		
		Assert.assertEquals(currentURL, "https://app.starbucks.com/gift");
	}
}

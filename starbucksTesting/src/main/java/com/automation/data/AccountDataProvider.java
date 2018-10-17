package com.automation.data;

import org.testng.annotations.DataProvider;

public class AccountDataProvider {

	@DataProvider(name = "userDataProvider")
    public static Object[][] loginDataProvider() {
        return new Object[][] { { "tae.globant.training@gmail.com", "GlobantTAE_1"}};
    }
	
	@DataProvider(name = "giftDataProvider")
	public static Object[][] giftDataProvider() {
        return new Object[][] {{ "MyName", "q@q.com"}};
    }
}

package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePage;
import com.automation.configurations.PropertyManager;

public class StarbucksHomePage extends BasePage {

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		String baseURL = PropertyManager.getInstance().getURL();
		driver.get(baseURL);
	}
	
	@FindBy(className="nav_menu")
	private WebElement mainMenu;
	
	
	public List<String> menuOptions() {
		List <String> menuOptions = new ArrayList<>();
		
		List<WebElement> subMenu = mainMenu.findElements(By.tagName("li"));
		for (WebElement webElement : subMenu) {
			menuOptions.add(webElement.getText().trim());
		}
		
		return menuOptions;
	}
}

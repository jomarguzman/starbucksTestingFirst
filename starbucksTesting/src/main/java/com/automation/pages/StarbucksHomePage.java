package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	@FindBy(css=".blocks.blocks-four-up")
	private WebElement  menuContent;
	
	@FindBy(id="signIn")
	private WebElement signIn;
	
	public List<String> menuOptions() {
		List <String> menuOptions = new ArrayList<>();
		
		List<WebElement> subMenu = mainMenu.findElements(By.tagName("li"));
		for (WebElement webElement : subMenu) {
			menuOptions.add(webElement.getText().toUpperCase());
		}
		
		return menuOptions;
	}
	
	public String menuCoffee() {
		
		List<WebElement> subMenu = mainMenu.findElements(By.tagName("li"));
		for (WebElement menuElement : subMenu) {
			if(menuElement.getText().equalsIgnoreCase(PropertyManager.getInstance().getMenuOption())) {
				getWait().until(ExpectedConditions.elementToBeClickable(menuElement));
				menuElement.click();
				
				getWait().until(ExpectedConditions.visibilityOfAllElements(menuContent));
				WebElement menuContentOption = menuContent.findElement(By.linkText("Find Your Perfect Coffee"));
				getWait().until(ExpectedConditions.elementToBeClickable(menuContentOption));
				menuContentOption.click();
				return getURL();
			}
		}
		return "";
	}
	
	public String navigateHomePage() {
		getWait().until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
		return getURL();
	}
}

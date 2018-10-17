package com.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDriver {
	
	Logger logger = LoggerFactory.getLogger(MyDriver.class);
	
	private WebDriver driver;
	
	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			logger.info("default IExplorer");
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			logger.info("default IExplorer");
			break;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}

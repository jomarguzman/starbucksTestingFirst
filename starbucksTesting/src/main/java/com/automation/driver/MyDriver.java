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
			setFirefox();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			setChrome();
			driver = new ChromeDriver();
			break;
		default:
			logger.info("default IExplorer");
			setIE();
			driver = new InternetExplorerDriver();
			logger.info("default IExplorer");
			break;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	private void setChrome(){
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		}
	}

	private void setFirefox(){
		if (System.getProperty("os.name").contains("mac")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		}
	}

	private void setIE(){
		if (System.getProperty("os.name").equalsIgnoreCase("mac")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/MicrosoftWebDriver");
		} else {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
		}
	}
}

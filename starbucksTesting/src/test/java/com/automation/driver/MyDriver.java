package com.automation.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyDriver {
	
	private WebDriver driver;
	
	public MyDriver(String browser) {
		switch (browser) {
		case "remateFirefox":
			try {
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/omar.guzman/Documents/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/omar.guzman/Documents/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "remoteFirefox":
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		break;
		default:
			System.out.println("default");
			break;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}

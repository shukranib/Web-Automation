package com.craftsvilla.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSelector {

	public static WebDriver getDriver() {
		WebDriver driver = null;
		DesiredCapabilities capability = null;
		PropertyReader configReader = new PropertyReader();
		String browser = configReader.getPropertyValue("browser");
		
		if (browser.equals("FF")) {
			System.out.println("firefox");

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get(configReader.getPropertyValue("url"));
			return driver;
		}

		if (browser.equals("CR")) {

			System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));
			return driver;

		}

		return driver;

	}

}

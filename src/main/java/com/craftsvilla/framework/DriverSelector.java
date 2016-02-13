package com.craftsvilla.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class DriverSelector {
	

	public static WebDriver getDriver() {
		WebDriver driver = null;
		DesiredCapabilities capability=null;
		PropertyReader configReader = new PropertyReader();
		String browser = configReader.getPropertyValue("browser");

		if (browser.equals("FF")) {
			System.out.println("firefox");

			driver=new FirefoxDriver();
			System.out.println("Creating mozilla driver");
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			driver.manage().window().maximize();
			System.out.println("Redirecting to url"+configReader.getPropertyValue("url"));
			Wait.defaultHighWait(driver);
			Screenshot.takeScreenshot(driver, "Login1");
			driver.get(configReader.getPropertyValue("url"));
			Wait.defaultHighWait(driver);
			Screenshot.takeScreenshot(driver, "Login2");
			return driver;
		}

		if (browser.equals("CR")) {
			System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver/chromedriver");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));
			return driver;

			
		}

		

		return driver;

	}

	public static WebDriver setupMozillaBrowser() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://dev3.craftsvilla.com/");
		driver.manage().window().maximize();
		Wait.defaultHighWait(driver);
		return driver;

	}
}

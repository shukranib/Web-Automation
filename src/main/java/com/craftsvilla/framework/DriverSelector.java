package com.craftsvilla.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSelector {
	static WebDriver driver;

	public static WebDriver getDriver() {
		PropertyReader configReader = new PropertyReader();
		String browser = configReader.getPropertyValue("browser");

		if (browser.equals("FF")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(configReader.getPropertyValue("url"));
			return driver;
		}

		if (browser.equals("CR")) {
			System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", "/home/Craftsvilla/Downloads/New/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("www.craftsvilla.com");
			return driver;

			/*
			 * File file = new
			 * File("/home/Craftsvilla/Downloads/New/chromedriver.exe");
			 * System.setProperty("webdriver.chrome.driver",
			 * file.getAbsolutePath()); Capability =
			 * DesiredCapabilities.chrome();
			 * Capability.setBrowserName("chrome");
			 * Capability.setPlatform(Platform.LINUX); // URL url=new URL
			 * 
			 * RemoteWebDriver remoteWebDriver = new
			 * RemoteWebDriver(Capability);
			 * remoteWebDriver.get("www.craftsvilla.com"); // RemoteWebDriver
			 * chromedriver = new // RemoteWebDriver("www.craftsvilla.com",
			 * Capability); remoteWebDriver.manage().window().maximize();
			 */
		}

		// driver.manage().window().maximize();

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

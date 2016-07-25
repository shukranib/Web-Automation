package com.craftsvilla.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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

	public static WebDriver getDriver_browserstack() {
		WebDriver driver = null;
		PropertyReader configReader = new PropertyReader();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.WINDOWS);
		capability.setCapability("build", "TestNG - Sample");

		try {
			driver = new RemoteWebDriver(
					new URL("https://abhipsasahu1:djb6gQSnhg15hHF5zG3n@hub-cloud.browserstack.com/wd/hub"), capability);
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}
}

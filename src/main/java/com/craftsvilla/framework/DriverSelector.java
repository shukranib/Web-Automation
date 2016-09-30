package com.craftsvilla.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
		System.out.println("Browser is" + browser);
		if (browser.equals("FF")) {
			System.out.println("firefox");

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get(configReader.getPropertyValue("url"));
			return driver;
		}
		if (browser.equals("CR"))

		{

			System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));
			return driver;

		}

		return driver;

	}

	public static WebDriver getDriver_browserstacknew() {

		WebDriver driver = null;

		PropertyReader configReader = new PropertyReader();
		DesiredCapabilities capability = new DesiredCapabilities();
		final String USERNAME = "abhipsasahu1";
		final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		System.out.println("################### Excuting Testcase############");

		try {
			driver = new RemoteWebDriver(new URL(URL), capability);
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));

		} catch (

		MalformedURLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

}

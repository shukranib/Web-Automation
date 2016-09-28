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
import org.testng.Assert;

import com.craftsvilla.dataobjects.EnvironmentBo;

public class DriverSelector {
	static PropertyReader configReader = new PropertyReader();

	public static WebDriver getDriver() {
		WebDriver driver = null;
		//	DesiredCapabilities capability = null;

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

	public static WebDriver getDriver_browserstacknew() {

		WebDriver driver = null;
		String osname = (EnvironmentBo.getOs()).trim();
		String version = (EnvironmentBo.getBrowserversion()).trim();
		String browserName = (EnvironmentBo.getBrowsersName()).trim();

		System.out.println("OS name" + osname);
		PropertyReader configReader = new PropertyReader();
		DesiredCapabilities capability = new DesiredCapabilities();
		final String USERNAME = "abhipsasahu1";
		final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		System.out.println("################### Excuting Testcase############");
		System.out.println("#######Browser is ===" + browserName);
		System.out.println("#######Version  is ===" + version);
		System.out.println("############ OS is ===" + osname);
		if (osname.equals("Windows 8")) {
			System.out.println("ON WINDOWS");
			capability.setPlatform(Platform.WIN8);
		}
		if (osname.equals("Windows 7")) {
			capability.setCapability("os", "Windows");
			capability.setCapability("os_version", "7");
			capability.setCapability("resolution", "1280x800");
		}
		if (osname.equalsIgnoreCase("WindowsXP")) {
			capability.setCapability("os", "Windows");
			capability.setCapability("os_version", "XP");
			capability.setCapability("resolution", "1280x800");
		}
		if (osname.equalsIgnoreCase("Windows10")) {
			capability.setCapability("os", "Windows");
			capability.setCapability("os_version", "10");
		}
		if (osname.trim().equalsIgnoreCase("Windows8.1")) {

			capability.setCapability("os", "Windows");
			capability.setCapability("os_version", "8.1");
			capability.setCapability("resolution", "1280x800");

		}
		if (osname.equalsIgnoreCase("Windows7")) {
			capability.setCapability("os", "Windows");
			capability.setCapability("os_version", "7");
			capability.setCapability("resolution", "1024x768");
		}
		if (osname.equalsIgnoreCase("OSX")) {
			capability.setCapability("os", "OS X");
			capability.setCapability("os_version", "El Capitan");
			capability.setCapability("resolution", "1280x960");
		}
		if (browserName.equalsIgnoreCase("Safari")) {
			System.out.println("Safari");
			capability.setCapability("browserstack.safari.driver", "2.45");
			capability.setCapability("browserstack.safari.enablePopups", "true");

		}
		if (browserName.equalsIgnoreCase("IE")) {
			capability.setCapability("browserstack.ie.driver", "2.45");
			capability.setCapability("browserstack.ie.enablePopups", "true");
		}
		capability.setCapability("build", "TestNG - Sample");
		capability.setBrowserName(browserName);
		capability.setVersion(version);
		try {
			driver = new RemoteWebDriver(new URL(URL), capability);
			driver.manage().window().maximize();
			driver.get(configReader.getPropertyValue("url"));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

	public static WebDriver getDriver_grid() {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			driver.get(configReader.getPropertyValue("url"));
			return driver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}

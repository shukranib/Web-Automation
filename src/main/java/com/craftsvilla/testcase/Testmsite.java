package com.craftsvilla.testcase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;

public class Testmsite {
	@Test
	public void msite() {
		WebDriver driver = null;
		PropertyReader configReader = new PropertyReader();
		DesiredCapabilities caps = new DesiredCapabilities();
		final String USERNAME = "abhipsasahu1";
		final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		caps.setCapability("browserName", "android");
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("device", "Sony Xperia Tipo");
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get(configReader.getPropertyValue("url"));

		/*Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/

		//driver.findElement(By.xpath(".//.[@class='user-icon-section']")).click();
		//AddToCart.addToCartWithoutLogin(driver);
		driver.get(configReader.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/test");
		Wait.defaultHighWait(driver);
		driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/button[@id='buynow']")).click();
		Wait.defaultHighWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
		driver.findElement(By.xpath(".//*[@id='checkoutFlow']/div[2]/div[4]/div/div/div[3]/div/input")).click();
		Wait.defaultHighWait(driver);
		CheckOutPage.enterEmailIdForGuestCheckout(driver);
		CheckOutPage.clickOnGuestCheckout(driver);
		Wait.defaultHighWait(driver);
		CommonFunctionRepo.enterBillingAddressGuest(driver);
		Wait.defaultMediumWait(driver);
		CheckOutPage.clickOnsaveAndContinueGuest(driver);
		//CheckOutPage.clickOnDeliverToThisAddressButton(driver);
		Wait.defaultHighWait(driver);

		driver.findElement(By.id("placeOrderAllMobileBtn")).click();
		Wait.defaultHighWait(driver);

		Wait.defaultHighWait(driver);
		String successurl = driver.getCurrentUrl();
		if (successurl.contains("payment-success")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.quit();/*	WebDriver driver;
						//	PropertyReader configReader = new PropertyReader();
						//DesiredCapabilities capability = new DesiredCapabilities();
						final String USERNAME = "abhipsasahu1";
						final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
						final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
						DesiredCapabilities caps = new DesiredCapabilities();
						
						caps.setCapability("browserName", "android");
						caps.setPlatform(Platform.ANDROID);
						caps.setCapability("device", "Samsung Galaxy S5");
						//capability.setCapability("device", "Galaxy S5");
						//capability.setCapability("os", "android");
						try {
						driver = new RemoteWebDriver(new URL(URL), caps);
						//driver.manage().window().maximize();
						driver.get("http://www.craftsvilla.com/");
						//driver.get("www.craftsvilla.com");
						Wait.defaultHighWait(driver);
						driver.get("https://securestatic.craftsvilla.com/customer/account/login/");
						Wait.defaultHighWait(driver);
						driver.findElement(By.xpath(".//*[@class='input form-group']/input[@id='email']"))
						.sendKeys("shukrani.bille@craftsvilla.com");
						Wait.defaultHighWait(driver);
						driver.findElement(By.xpath(".//*[@class='input form-group']/input[@id='pass']")).sendKeys("123456");
						Wait.defaultHighWait(driver);
						driver.findElement(By.id("send2")).click();
						Wait.defaultHighWait(driver);
						
						} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
						//return driver;
						
						//html/body/div[1]/div[2]/div/div[1]/div[1]/div/a[3]/svg
						//.//*[@class="input form-group"]/input[@id='email']
						//.///*[@class="input form-group"]/input[@id='pass']
						//login button.//*[@id='send2']*/
	}
}
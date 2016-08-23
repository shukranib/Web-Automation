package com.craftsvilla.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Testmsite {
	long endtime;
	long starttime;
	long totaltime;
	static AndroidDriver<MobileElement> driver = null;
	static FileWriter writer;
	MobileElement requiredElement;

	@Test
	public void msite_afterdep() {

		try {
			PropertyReader read = new PropertyReader();
			File csvfile = new File("src/main/resources/Input/PerformanceReport.csv");
			if (!csvfile.exists()) {
				try {
					csvfile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("FILE is created");
			}
			Date date = new Date();
			String datestring = date.toString();
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append(";");
			writer.append("Date and time");
			writer.append("\n");

			//PropertyReader read = new PropertyReader();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "Chrome");
			cap.setCapability("deviceName", "65a2b779");
			cap.setPlatform(Platform.ANDROID);

			/*com.craftsvilla.app:id/textviewFilter 
			com.craftsvilla.app:id/tvFilterNameMain text=COD
					com.craftsvilla.app:id/checkboxSubCategory//checkbox
					com.craftsvilla.app:id/filtersApplyButton//apply button*/
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
			/*Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Google Nexus 5");
			
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			WebDriver driver = new ChromeDriver(capabilities);*/
			driver.get("http://www.craftsvilla.com/");
			Wait.defaultHighWait(driver);
			if (read.getPropertyValue("prodenv").equalsIgnoreCase("N")) {
				System.out.println("Stagging environment");
				driver.get("http://dev6.craftsvilla.com/activate");
				Wait.defaultMediumWait(driver);
				driver.findElement(By.id("dev7")).click();
				Wait.defaultMediumWait(driver);
				driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/3522831");
				Wait.defaultHighWait(driver);

			} else {
				driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/self-red");
			}
			//driver.findElement(By.xpath(".//.[@class='user-icon-section']")).click();
			//AddToCart.addToCartWithoutLogin(driver);
			//	driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/test");
			Wait.defaultHighWait(driver);

			//driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/button[@id='buynow']")).click();
			driver.findElement(By
					.xpath(".//*[@id='buynow'][@class='button-custom text-uppercase green_button mobile_fixed_button buyNow_mobile']"))
					.click();
			//driver.findElement(By
			//	.xpath("//*[@id='buynow'][@class='button-custom text-uppercase green_button mobile_fixed_button buyNow_mobile']"))
			//.click();
			Wait.defaultHighWait(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("BUY now button");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_proceedToPayment);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for cart Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			Wait.defaultHighWait(driver);
			//DriverActions.scrollDownWindow(driver);
			Wait.defaultHighWait(driver);
			//CheckOutPage.clickOncontinueAsGuestButton(driver);
			//driver.findElement(By.xpath(".//*[@id='checkoutFlow']/div[2]/div[4]/div/div/div[3]/div/input")).click();

			driver.findElement(By.xpath(".//*[@id='checkoutFlow']/div[3]/div[3]/div/div/div[3]/div/input")).click();
			Wait.defaultHighWait(driver);
			CheckOutPage.enterEmailIdForGuestCheckout(driver);
			CheckOutPage.clickOnGuestCheckout(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.textBox_firstNameBillingInfo);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for shipping  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			CommonFunctionRepo.enterBillingAddressGuest(driver);
			Wait.defaultMediumWait(driver);
			//driver.findElement(By
			//.xpath(".//*[@id='checkoutFlow']/div[2]/div[4]/div/div[2]/div/div/div/div[1]/form/div[11]/button"))
			//.click();

			CheckOutPage.clickOnsaveAndContinueGuest(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			//requiredElement = driver.findElement(By.xpath(".//*[@class='sprite sprite-carrier-maroon-bg']"));
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.paymenticon_paymentpage);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for payment  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);

			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			//driver.findElement(By.xpath(".//*[@id='placeOrderAllMobileBtn']")).click();

			CheckOutPage.clickOnCODOrderPlace(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.span_thankyou);
			endtime = System.currentTimeMillis();
			writer.append("Total time required Order confirmation  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.assertTrue(false);/*	WebDriver driver;
										}
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
		} finally {
			driver.quit();

			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void msite_beforedep() {

		try {
			PropertyReader read = new PropertyReader();
			File csvfile = new File("src/main/resources/Input/PerformanceReport.csv");
			if (!csvfile.exists()) {
				try {
					csvfile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("FILE is created");
			}
			Date date = new Date();
			String datestring = date.toString();
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append(";");
			writer.append("Date and time");
			writer.append("\n");

			//PropertyReader read = new PropertyReader();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "Chrome");
			cap.setCapability("deviceName", "65a2b779");
			cap.setPlatform(Platform.ANDROID);

			/*com.craftsvilla.app:id/textviewFilter 
			com.craftsvilla.app:id/tvFilterNameMain text=COD
					com.craftsvilla.app:id/checkboxSubCategory//checkbox
					com.craftsvilla.app:id/filtersApplyButton//apply button*/
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
			/*Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Google Nexus 5");
			
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			WebDriver driver = new ChromeDriver(capabilities);*/
			driver.get("http://www.craftsvilla.com/");
			Wait.defaultHighWait(driver);
			if (read.getPropertyValue("prodenv").equalsIgnoreCase("N")) {
				System.out.println("Stagging environment");
				driver.get("http://dev6.craftsvilla.com/activate");
				Wait.defaultMediumWait(driver);
				driver.findElement(By.id("dev7")).click();
				Wait.defaultMediumWait(driver);
				driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/3522831");
				Wait.defaultHighWait(driver);

			} else {
				driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/self-red");
			}
			//driver.findElement(By.xpath(".//.[@class='user-icon-section']")).click();
			//AddToCart.addToCartWithoutLogin(driver);
			//	driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/test");
			Wait.defaultHighWait(driver);

			//driver.findElement(By.xpath(".//*[@id='product_addtocart_form']/button[@id='buynow']")).click();
			//	driver.findElement(
			//By.xpath(".//*[@id='buynow'][@class='col-xs-12 buy_now cart_buy_buttons buyNow_desktop']")).click();
			driver.findElement(By
					.xpath("//*[@id='buynow'][@class='button-custom text-uppercase green_button mobile_fixed_button buyNow_mobile']"))
					.click();
			Wait.defaultHighWait(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("BUY now button");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_proceedToPayment);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for cart Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			Wait.defaultHighWait(driver);
			//DriverActions.scrollDownWindow(driver);
			Wait.defaultHighWait(driver);
			//CheckOutPage.clickOncontinueAsGuestButton(driver);
			driver.findElement(By.xpath(".//*[@id='checkoutFlow']/div[2]/div[4]/div/div/div[3]/div/input")).click();

			//driver.findElement(By.xpath(".//*[@id='checkoutFlow']/div[3]/div[3]/div/div/div[3]/div/input")).click();
			Wait.defaultHighWait(driver);
			CheckOutPage.enterEmailIdForGuestCheckout(driver);
			CheckOutPage.clickOnGuestCheckout(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.textBox_firstNameBillingInfo);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for shipping  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			CommonFunctionRepo.enterBillingAddressGuest(driver);
			Wait.defaultMediumWait(driver);
			driver.findElement(By
					.xpath(".//*[@id='checkoutFlow']/div[2]/div[4]/div/div[2]/div/div/div/div[1]/form/div[11]/button"))
					.click();

			//	CheckOutPage.clickOnsaveAndContinueGuest(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			//requiredElement = driver.findElement(By.xpath(".//*[@class='sprite sprite-carrier-maroon-bg']"));
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.paymenticon_paymentpage);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for payment  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);

			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			driver.findElement(By.xpath(".//*[@id='placeOrderAllMobileBtn']")).click();

			//CheckOutPage.clickOnCODOrderPlace(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.span_thankyou);
			endtime = System.currentTimeMillis();
			writer.append("Total time required Order confirmation  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.assertTrue(false);/*	WebDriver driver;
										}
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
		} finally {
			driver.quit();

			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public long calculatetimeinsec(long starttime, long endtime) {

		totaltime = ((endtime - starttime) / 1000);
		return totaltime;

	}

	public void reset() {
		starttime = 0;
		endtime = 0;
		totaltime = 0;
	}
}
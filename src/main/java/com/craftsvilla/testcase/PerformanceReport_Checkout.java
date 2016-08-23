package com.craftsvilla.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class PerformanceReport_Checkout {
	static WebDriver driver;
	long endtime;
	long starttime;
	float totaltime;
	static FileWriter writer;

	@Test
	public void loadingTimeForCategoryPage_checkout() {
		DesiredCapabilities capability = new DesiredCapabilities();
		final String USERNAME = "abhipsasahu1";
		final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		capability.setPlatform(Platform.WIN8);
		capability.setCapability("BrowserName", "Firefox");
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
		try {
			Date date = new Date();
			String datestring = date.toString();
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append(";");
			writer.append("Date and time");
			writer.append("\n");

			//driver = new FirefoxDriver();
			driver = new RemoteWebDriver(new URL(URL), capability);
			driver.manage().window().maximize();
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
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_buyNow);
			endtime = System.currentTimeMillis();
			writer.append("Time to load Buy now button");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			HomePage.clickOnBuyNowButton(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("BUY now button");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.learnmore_cartpage);
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
			DriverActions.scrollDownWindow(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.clickOncontinueAsGuestButton(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.enterEmailIdForGuestCheckout(driver);
			CheckOutPage.clickOnGuestCheckout(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.shippingicon_shippingpage);
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
			//CheckOutPage.clickOnsaveAndContinueGuest(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void loadingTimeForCategoryPage_checkoutafter() {
		DesiredCapabilities capability = new DesiredCapabilities();
		final String USERNAME = "abhipsasahu1";
		final String AUTOMATE_KEY = "djb6gQSnhg15hHF5zG3n";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		capability.setPlatform(Platform.WIN8);
		capability.setCapability("BrowserName", "Firefox");

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
		try {
			Date date = new Date();
			String datestring = date.toString();
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append(";");
			writer.append("Date and time");
			writer.append("\n");
			driver = new RemoteWebDriver(new URL(URL), capability);
			//driver = new FirefoxDriver();
			driver.manage().window().maximize();
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
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_buyNow);
			endtime = System.currentTimeMillis();
			writer.append("Time to load Buy now button");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultsmallWait(driver);
			HomePage.clickOnBuyNowButton(driver);
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

			Wait.defaultHighWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			Wait.defaultHighWait(driver);
			DriverActions.scrollDownWindow(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.clickOncontinueAsGuestButton(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.enterEmailIdForGuestCheckout(driver);
			CheckOutPage.clickOnGuestCheckout(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.shippingicon_shippingpage);
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
			CheckOutPage.clickOnsaveAndContinueGuest(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("Shipping page");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.paymenticon_paymentpage);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for payment  Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);

			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public float calculatetimeinsec(long starttime, long endtime) {

		totaltime = ((endtime - starttime) / 1000);
		return totaltime;

	}

	public void reset() {
		starttime = 0;
		endtime = 0;
		totaltime = 0;
	}
}

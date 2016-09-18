package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.CheckOut;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;

public class OrderPlacing {
	WebDriver driver;

	@Test()
	public void addToCartTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLogin(driver);

	}

	@Test(testName = "codOrderPlaceTest")
	public void codOrderPlaceTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@Test
	public void codOrderAfterLogin() {
		driver = DriverSelector.getDriver_browserstacknew();
		CheckOut.codOrderAfterLogin(driver);
		driver.quit();
	}

	@Test
	public void codOrderPlaceAddtoCartThenregister() {
		driver = DriverSelector.getDriver_browserstacknew();
		CheckOut.codOrderPlaceAddtoCartThenregister(driver);
	}

	@Test
	public void codOrderPlaceAddtoCartThenLogin() {
		driver = DriverSelector.getDriver_browserstacknew();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@Test
	public void prepaidOrderWithGuestCheckout() {
		driver = DriverSelector.getDriver();
		CheckOut.PrePaymentOrderPlace(driver);
	}

	@Test
	public void codOrderPlaceGuestCheckout() {
		driver = DriverSelector.getDriver_browserstacknew();
		Assert.assertTrue(CheckOut.codOrderPlaceGuestCheckout(driver));
	}

	@Test(dependsOnMethods = { "codOrderPlaceGuestCheckout" })
	public void cancelfirstOrder() {
		CheckOut.cancelFirstOrderFromOrderHistory(driver, "Test");
		driver.quit();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();
	}

}

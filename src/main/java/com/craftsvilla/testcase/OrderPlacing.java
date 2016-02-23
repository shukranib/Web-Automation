package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.CheckOut;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;

public class OrderPlacing {
	WebDriver driver;

	@Test()
	public void addToCartTest() {
		driver = DriverSelector.getDriver();
		AddToCart.addToCartWithoutLogin(driver);

	}

	@Test
	public void codOrderPlaceTest() {
		driver = DriverSelector.getDriver();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@Test
	public void codOrderAfterLogin() {
		driver = DriverSelector.getDriver();
		CheckOut.codOrderAfterLogin(driver);
	}

	@Test
	public void codOrderPlaceAddtoCartThenregister() {
		driver = DriverSelector.getDriver();
		CheckOut.codOrderPlaceAddtoCartThenregister(driver);
	}

	@Test
	public void codOrderPlaceAddtoCartThenLogin() {
		driver = DriverSelector.getDriver();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@Test
	public void codOrderPlaceGuestCheckout() {
		driver = DriverSelector.getDriver();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			Wait.defaultHighWait(driver);
			Screenshot.takeScreenshot(driver, result.getName());

		}
		driver.quit();

	}
}

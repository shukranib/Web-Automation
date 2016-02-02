package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverSelector;

import commonflow.AddToCart;
import commonflow.CheckOut;

public class OrderPlacing {
	WebDriver driver;

	@Test()
	public void addToCartTest() {
		driver = DriverSelector.getDriver();
		AddToCart addToCart = new AddToCart();
		addToCart.addFirstProductToCart(driver);

	}

	@Test
	public void codOrderPlaceTest() {
		driver = DriverSelector.getDriver();
		CheckOut.CODOrderPlaceAfterRegister(driver);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}
}

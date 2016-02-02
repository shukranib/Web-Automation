package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverSelector;

import commonflow.WishList;
import pageObjects.HomePage;

public class Sanity {
	WebDriver driver;
	boolean result;

	@Test(enabled = false)
	public void searchTest() {
		driver = DriverSelector.getDriver();
		HomePage.enterTextToSearch(driver);

	}

	@Test()
	public void clickOnAllLinkFromHomePageTest() {
		driver = DriverSelector.getDriver();

		HomePage.clickOnAllCategoryFromHomepage(driver);
	}

	@Test
	public void clickOnAllFeedPageTest() {
		driver = DriverSelector.getDriver();
		HomePage.clickOnAllFeedPages(driver);

	}

	@Test()
	public void addProductToWishlistTest() {
		driver = DriverSelector.getDriver();
		result = WishList.addToWishListAfterRegister(driver);
		Assert.assertTrue(result);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}
}

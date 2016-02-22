package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.SortFlow;
import com.craftsvilla.commonflow.WishList;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.pageObjects.HomePage;

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

	@Test
	public void verifyAscSortOnCategoryPage() {
		driver = DriverSelector.getDriver();
		SortFlow.ascSortOnCategoryPage(driver);

	}

	@Test
	public void verifypriceFilter500_1000CategoryPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter500_1000(driver));

	}

	@Test
	public void verifypriceFilter1000_2000CategoryPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter1000_2000(driver));

	}

	@Test
	public void verifypriceFilter500_1000SearchPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter500_1000(driver));

	}

	@Test
	public void verifypriceFilter1000_2000SearchPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter1000_2000(driver));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}
}

package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.SortFlow;
import com.craftsvilla.commonflow.WishList;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ProductPages;

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
		ProductPages.applypricefilter500_1000(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 500, 1000));

	}

	@Test
	public void verifypriceFilter1000_2000CategoryPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter1000_2000(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 1000, 2000));

	}

	@Test
	public void verifypriceFilter500_1000SearchPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter500_1000OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 500, 1000));

	}

	@Test
	public void verifypriceFilter1000_2000SearchPage() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter1000_2000OnsearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 1000, 2000));

	}

	@Test
	public void VerifyPriceFilter0_500CategoryPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter0_500(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void VerifyPriceFilter0_500SearchPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter0_500OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void VerifyPriceFilterAbove5000CategoryPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applyPriceFilterAbove5000(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
	}

	@Test
	public void VerifyPriceFilterAbove5000SearchPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applyPriceFilterAbove5000OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
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

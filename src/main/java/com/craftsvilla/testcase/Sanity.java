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
import com.craftsvilla.framework.FailedTestCases;
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
	public void verifyPriceFilter0_500CategoryPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter0_500(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void verifyPriceFilter0_500SearchPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter0_500OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void verifyPriceFilter2000_5000CategoryPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter2000_5000(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 2000, 5000));
	}

	@Test
	public void verifyPriceFilter2000_5000SearchPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter2000_5000OnsearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 2000, 5000));
	}

	@Test
	public void verifyPriceFilterAbove5000CategoryPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applyPriceFilterAbove5000(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
	} 

	@Test
	public void verifyPriceFilterAbove5000SearchPageTest() {
		driver = DriverSelector.getDriver();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applyPriceFilterAbove5000OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
	}
	@Test
	public void testASCPriceSortingOnCategoryPage() {
		driver = DriverSelector.getDriver();
		HomePage.clickOnFistCategory(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}
	

	@Test
	public void testDSCPriceSortingOnCategoryPage() {
		driver = DriverSelector.getDriver();
		HomePage.clickOnFistCategory(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "DSC"));
	}

	@Test
	public void testASCPriceSortingOnSearchPage() {
		driver = DriverSelector.getDriver();
		HomePage.enterTextToSearch(driver,"Kareena kapoor");
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}
	

	@Test
	public void testDSCPriceSortingOnSearchPage() {
		driver = DriverSelector.getDriver();
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "DSC"));
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();

	}

}

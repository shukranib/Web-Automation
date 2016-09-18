package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.SortFlow;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ProductPages;

public class Sanity {
	WebDriver driver;
	boolean result;

	@Test(enabled = false)
	public void searchTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		HomePage.enterTextToSearch(driver);

	}

	@Test()
	public void clickOnAllLinkFromHomePageTest() {
		driver = DriverSelector.getDriver_browserstacknew();

		HomePage.clickOnAllCategoryFromHomepage(driver);
	}

	@Test
	public void clickOnAllFeedPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		HomePage.clickOnAllFeedPages(driver);

	}

	@Test
	public void verifypriceFilter500_1000CategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter500_1000(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 500, 1000));

	}

	@Test
	public void verifypriceFilter1000_2000CategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter1000_2000(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 1000, 2000));

	}

	@Test
	public void verifypriceFilter500_1000SearchPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter500_1000OnSearchPage(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 500, 1000));

	}

	@Test
	public void verifypriceFilter1000_2000SearchPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter1000_2000OnsearchPage(driver);
		System.out.println("CLICKED");
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 1000, 2000));
		System.out.println("CLICKED");
		Wait.defaultMediumWait(driver);

	}

	@Test
	public void verifyPriceFilter0_500CategoryPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();

		FiltersFlow.gotosubcategory(driver);
		System.out.println("TEST");
		ProductPages.applypricefilter0_500(driver);
		System.out.println("TEST");
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
		System.out.println("TEST");
	}

	@Test
	public void verifyPriceFilter0_500SearchPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter0_500OnSearchPage(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void verifyPriceFilter2000_5000CategoryPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applypricefilter2000_5000(driver);
		//	Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 2000, 5000));
	}

	@Test
	public void verifyPriceFilter2000_5000SearchPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter2000_5000OnsearchPage(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 2000, 5000));
	}

	@Test
	public void verifyPriceFilterAbove5000CategoryPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		ProductPages.applyPriceFilterAbove5000(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
	}

	@Test
	public void verifyPriceFilterAbove5000SearchPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applyPriceFilterAbove5000OnSearchPage(driver);
		//Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 5000, 0));
	}

	@Test
	public void testASCPriceSortingOnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "ASC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}

	@Test
	public void testDSCPriceSortingOnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "DSC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "DSC"));
	}

	@Test
	public void testASCPriceSortingOnSearchPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSorting(driver, "ASC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}

	@Test
	public void testdiscountFilterAbove50_OnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultMediumWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultMediumWait(driver);
		ProductPages.clickToExpandDiscountFilter(driver);
		Wait.defaultHighWait(driver);
		//DriverActions.scrollDownWindowsmall(driver);
		ProductPages.applyDiscountFilterAbove50(driver);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(FiltersFlow.applyDiscountFilter(driver, 50));
	}

	@Test
	public void testdiscountFilterAbove40_OnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultMediumWait(driver);
		ProductPages.clickToExpandDiscountFilter(driver);
		ProductPages.applyDiscountFilterAbove40(driver);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(FiltersFlow.applyDiscountFilter(driver, 40));

	}

	@Test
	public void testdiscountFilterAbove30_OnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultMediumWait(driver);
		ProductPages.clickToExpandDiscountFilter(driver);
		ProductPages.applyDiscountFilterAbove30(driver);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(FiltersFlow.applyDiscountFilter(driver, 30));
	}

	@Test
	public void testdiscountFilterAbove20_OnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultMediumWait(driver);
		ProductPages.clickToExpandDiscountFilter(driver);
		ProductPages.applyDiscountFilterAbove20(driver);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(FiltersFlow.applyDiscountFilter(driver, 20));
	}

	@Test
	public void testdiscountFilterAbove10_OnCategoryPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultMediumWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultMediumWait(driver);
		ProductPages.clickToExpandDiscountFilter(driver);
		Wait.defaultMediumWait(driver);
		//DriverActions.scrollDownWindowsmall(driver);
		ProductPages.applyDiscountFilterAbove10(driver);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(FiltersFlow.applyDiscountFilter(driver, 10));
	}

	@Test
	public void testDSCPriceSortingOnSearchPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSorting(driver, "DSC");
		Wait.defaultHighWait(driver);
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

package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ProductPages;

public class FiltersFlow {
	public static void gotosubcategory(WebDriver driver) {
		HomePage.clickOnFistCategory(driver);
		Wait.defaultMediumWait(driver);
		/*
		 * HomePage.clickOnViewMoreButtonForSubcategory(driver);
		 * Wait.defaultMediumWait(driver); //
		 * DriverActions.scrollDownhalfWindow(driver); //
		 * Wait.defaultHighWait(driver); HomePage.clickOnSubCategory(driver);
		 * Wait.defaultMediumWait(driver);
		 */

	}

	public static void goToSearchPage(WebDriver driver) {
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
	}

	public static boolean applyPriceFilter500_1000(WebDriver driver)

	{
		boolean result;

		// ProductPages.applypricefilter500_1000(driver);
		Wait.defaultMediumWait(driver);
		Screenshot.takeScreenshot(driver, "pricefilter500to1000");
		Wait.defaultMediumWait(driver);
		result = ProductPages.getPriceofproductsOncategorypage(driver, 500, 1000);
		return result;
	}

	public static boolean applyPriceFilter1000_2000(WebDriver driver)

	{
		boolean result;

		// ProductPages.applypricefilter1000_2000(driver);
		Wait.defaultMediumWait(driver);
		Screenshot.takeScreenshot(driver, "pricefilter1000To2000");
		Wait.defaultMediumWait(driver);

		result = ProductPages.getPriceofproductsOncategorypage(driver, 1000, 2000);
		return result;
	}

	public static boolean applyPriceFilter2000_5000(WebDriver driver)

	{
		boolean result;

		ProductPages.applypricefilter2000_5000(driver);
		Wait.defaultMediumWait(driver);
		Screenshot.takeScreenshot(driver, "pricefilter2000To5000");
		Wait.defaultMediumWait(driver);
		result = ProductPages.getPriceofproductsOncategorypage(driver, 2000, 5000);
		return result;
	}

}

package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.ProductPages;

public class SortFlow {
	public static boolean priceSortOnCategoryPage(WebDriver driver, String sort) {
		boolean result;

		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSorting(driver, sort);
		Wait.defaultHighWait(driver);
		result = ProductPages.getPriceofproductsOncategorypage(driver, sort);
		Wait.defaultHighWait(driver);
		return result;

	}

	public void ascSortOnsearchPage(WebDriver driver) {

	}

	public void dscSortOnCategoryPage(WebDriver driver) {

	}

	public void dscSortOnsearchPage(WebDriver driver) {
	}
}
package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ProductPages;

public class FiltersFlow {
	public static void gotosubcategory(WebDriver driver) {
		//HomePage.clickOnFistCategory(driver);
		driver.get("http://www.craftsvilla.com/womens-clothing/salwar-suits/");
		Wait.defaultMediumWait(driver);
	}

	public static void goToSearchPage(WebDriver driver) {
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
	}

	public static boolean applyPriceFilter(WebDriver driver, int min, int max) {
		Boolean result;
		Wait.defaultMediumWait(driver);
		result = ProductPages.getPriceofproductsOncategorypage(driver, min, max);
		System.out.println("TEST");
		return result;
	}

}

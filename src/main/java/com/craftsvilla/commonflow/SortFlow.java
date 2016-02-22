package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.TestData;

public class SortFlow {
public static void ascSortOnCategoryPage(WebDriver driver)
{
	HomePage.clickOnFistCategory(driver);
	Wait.defaultMediumWait(driver);
	HomePage.clickOnViewMoreButtonForSubcategory(driver);
	Wait.defaultMediumWait(driver);
	HomePage.clickOnSubCategory(driver);
	Wait.defaultMediumWait(driver);
	
}
public void ascSortOnsearchPage(WebDriver driver)
{
	
}
public void dscSortOnCategoryPage(WebDriver driver)
{
	
}
public void dscSortOnsearchPage(WebDriver driver)
{
}
}
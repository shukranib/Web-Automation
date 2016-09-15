package com.craftsvilla.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.CheckOut;
import com.craftsvilla.commonflow.Tracking;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.pageObjects.HomePage;

public class TestMidTracking {
	static PropertyReader read = new PropertyReader();
	static WebDriver driver;
	String pageName, pageType, pageURL, productID, categoryName, subcategoryName, deviceType, currencyCode;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SoftAssert softAssert = new SoftAssert();
	VerifyError verify = new VerifyError();

	@Test
	public void testPDPTracking() {
		boolean flag = true;
		String pageStrorage;
		WebDriver driver = DriverSelector.getDriver();
		driver.get(
				"http://www.craftsvilla.com/catalog/product/view/id/4543678/s/blue-orange-beautyfull-cotton-patiala");
		pageName = Tracking.return_pageName(driver);
		pageType = Tracking.return_pageType(driver);
		deviceType = Tracking.return_deviceType(driver);
		productID = Tracking.getvalue(driver, "digitalData.product[0].productInfo.productID");
		currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
		pageStrorage = Tracking.getvalue(driver, "digitalData.product.storage");
		categoryName = Tracking.getvalue(driver, "digitalData.product[0].productInfo.subCategory0");
		try {
			Assert.assertEquals(currencyCode, "INR");

			Assert.assertTrue(Tracking.testBuynow_MIDtracking(driver), "Assertion for BuyNow fails");
			Assert.assertEquals(productID, "4543678");
			Assert.assertEquals(pageStrorage, "local");
			Assert.assertEquals(deviceType, "NotMobile");
			Assert.assertEquals(categoryName, "Women's Fashion");
			Assert.assertEquals(pageName, "pdp:Women's Fashion:4543678");
			Assert.assertTrue(Tracking.testAddtocart_MIDtracking(driver), "Assertion for Addtocart fails");

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);

	}

	@Test
	public void testCategoryPageTracking() {
		boolean flag = true;
		driver = DriverSelector.getDriver();
		pageName = Tracking.return_pageName(driver);
		pageType = Tracking.return_pageType(driver);
		deviceType = Tracking.return_deviceType(driver);
		currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
		try {
			Assert.assertEquals(pageType, "home");
			Assert.assertEquals(deviceType, "NotMobile", "Wrong device type");
			Assert.assertEquals(pageName, "home page", "Wrong page name");
			Assert.assertEquals(currencyCode, "INR", "Wrong currency");

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);
	}

	@Test
	public void testOrdersuccessPageTracking() {
		boolean flag = true;
		String searchText, totalorderamttrack, totalorderamtpage;
		driver = DriverSelector.getDriver();
		boolean orderplace = CheckOut.codOrderPlaceGuestCheckout(driver);
		Assert.assertTrue(orderplace);
		totalorderamtpage = driver
				.findElement(By.xpath(".//*[@id='checkoutFlow']/div[2]/div[2]/div[3]/div[3]/div[3]/div[2]/strong"))
				.getText();
		try {
			pageName = Tracking.return_pageName(driver);
			pageType = Tracking.return_pageType(driver);
			deviceType = Tracking.return_deviceType(driver);

			currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
			searchText = Tracking.getvalue(driver, "digitalData.page.search.searchText");
			//Tracking.getvalue(driver, "")
			totalorderamttrack = Tracking.getvalue(driver, "digitalData.totalOrderValue");
			Assert.assertEquals(totalorderamtpage, totalorderamttrack, "Wrong amount");
			Assert.assertEquals(deviceType, "NotMobile", "Wrong device type");
			Assert.assertEquals(pageName, "order complete", "Wrong page name");
			Assert.assertEquals(currencyCode, "INR", "Wrong currency");
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);

	}

	public void testCartPageTracking() {
		boolean flag = true;
		String searchText, totalorderamttrack, totalorderamtpage;
		driver = DriverSelector.getDriver();
		AddToCart.addFirstProductToCart(driver);

		try {
			pageName = Tracking.return_pageName(driver);
			pageType = Tracking.return_pageType(driver);
			deviceType = Tracking.return_deviceType(driver);
			currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
			//searchText = Tracking.getvalue(driver, "digitalData.page.search.searchText");

			Assert.assertEquals(deviceType, "NotMobile", "Wrong device type");
			Assert.assertEquals(pageName, "cart", "Wrong page name");
			Assert.assertEquals(currencyCode, "INR", "Wrong currency");
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);

	}

	@Test
	public void testsearchPageTracking() {
		boolean flag = true;
		String searchText, searchCount;
		driver = DriverSelector.getDriver();
		HomePage.enterTextToSearch(driver);
		pageName = Tracking.return_pageName(driver);
		pageType = Tracking.return_pageType(driver);
		deviceType = Tracking.return_deviceType(driver);
		currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
		searchText = Tracking.getvalue(driver, "digitalData.page.search.searchText");
		searchCount = Tracking.getvalue(driver, "digitalData.page.search.searchCount");

		try {
			Assert.assertEquals(searchText, "Kareena", "Wrong Search Text");
			Assert.assertEquals(pageType, "home");
			Assert.assertEquals(deviceType, "NotMobile", "Wrong device type");
			Assert.assertEquals(pageName, "search:kareena", "Wrong page name");
			Assert.assertEquals(currencyCode, "INR", "Wrong currency");

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);
	}

	@Test
	public void testHomePageTracking() {
		boolean flag = true;
		driver = DriverSelector.getDriver();
		pageName = Tracking.return_pageName(driver);
		pageType = Tracking.return_pageType(driver);
		deviceType = Tracking.return_deviceType(driver);
		currencyCode = Tracking.getvalue(driver, "digitalData.page.currencycode.currencyCode");
		try {
			Assert.assertEquals(pageType, "home");
			Assert.assertEquals(deviceType, "NotMobile", "Wrong device type");
			Assert.assertEquals(pageName, "home page", "Wrong page name");
			Assert.assertEquals(currencyCode, "INR", "Wrong currency");

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Error in reponse");
			flag = false;

			//e.printStackTrace();

			// TODO: handle exception
		}
		Assert.assertTrue(flag);
	}

	@Test
	public void scripttag_homepage() {
		driver = DriverSelector.getDriver();
		Assert.assertTrue(Tracking.getscripttag(driver));

	}

	@Test
	public void scripttag_categorypage() {
		driver = DriverSelector.getDriver();
		driver.get(read.getPropertyValue("url") + "/womens-clothing/sarees/");
		Assert.assertTrue(Tracking.getscripttag(driver));
	}

	@Test
	public void scripttag_subcategorypage() {
		driver = DriverSelector.getDriver();
		driver.get(read.getPropertyValue("url") + "/womens-clothing/sarees/cotton-sarees/");
		Assert.assertTrue(Tracking.getscripttag(driver));

	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();

	}

}

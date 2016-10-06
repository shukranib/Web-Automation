package com.craftsvilla.testcase;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.CheckOut;
import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.Register;
import com.craftsvilla.commonflow.SortFlow;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.AddToCartPage;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;
import com.craftsvilla.pageObjects.ProductPages;
import com.craftsvilla.pageObjects.TestData;

public class SanityTestcases {
	WebDriver driver;
	PropertyReader read = new PropertyReader();

	@Test()
	public void RegisterTest() {
		Boolean result;
		driver = DriverSelector.getDriver_browserstacknew();

		result = Register.registerFlow(driver);
		// Screenshot.takeScreenshot(driver);
		Wait.defaultMediumWait(driver);
		Assert.assertTrue(!result);

	}

	@Test()
	public void addToCartTestWithLogin() {
		boolean flag = true;
		driver = DriverSelector.getDriver_browserstacknew();

		AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		String firstprodprice_pdp = DriverActions.getText(driver, ObjectRepository_HomePage.product_priceonPDP);
		int firstprodpdp = AddToCartPage.formatOrderamountinInteger(driver, firstprodprice_pdp);
		DriverActions.click(driver, ObjectRepository_HomePage.Span_noofproductincartonproduct);
		Wait.defaultHighWait(driver);
		String ordertotal = AddToCartPage.getorderAmount(driver);
		int ordertotalint = AddToCartPage.formatOrderamountinInteger(driver, ordertotal);
		Assert.assertEquals(firstprodpdp, ordertotalint);
		try {

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void prepaidOrderWithGuestCheckout() {
		driver = DriverSelector.getDriver_browserstacknew();
		CheckOut.PrePaymentOrderPlace(driver);
	}

	@Test
	public void testquantitymodificationAddtoCart()

	{
		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		String amount = AddToCartPage.getorderAmount(driver);
		//amount = amount.replace(",", " ");

		//amount = amount.trim();
		int beforeamt = AddToCartPage.formatOrderamountinInteger(driver, amount);
		System.out.println("amount" + amount);
		AddToCartPage.increaseOrdecreasequantity(driver, "2");
		Wait.defaultHighWait(driver);
		amount = AddToCartPage.getorderAmount(driver);

		int afteramt = AddToCartPage.formatOrderamountinInteger(driver, amount);
		int totalamt = beforeamt * 2;
		if (totalamt == afteramt) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void codOrderPlaceGuestCheckout() {
		driver = DriverSelector.getDriver_browserstacknew();
		Assert.assertTrue(CheckOut.codOrderPlaceGuestCheckout(driver));
	}

	@Test
	public void verifyPriceFilter0_500SearchPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		FiltersFlow.goToSearchPage(driver);
		ProductPages.applypricefilter0_500OnSearchPage(driver);
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
	}

	@Test
	public void colorfilteTestOnSearchPage() {
		driver = DriverSelector.getDriver_browserstacknew();
		HomePage.enterTextToSearch(driver, "Kareena kapoor");
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.FirstColorFromColorFilter_search);
		String prodcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_lastPageNo);

		prodcount = prodcount.replace("PRODUCTS", "  ");
		prodcount = prodcount.trim();
		int prodcountint = Integer.parseInt(prodcount);
		System.out.println("Product is" + prodcount);
		if (prodcountint > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void subCategoryDiscountFilter() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
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
	public void subCategoryPriceFilterFilter() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.applypricefilter0_500(driver);
		System.out.println("TEST");
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
		System.out.println("TEST");
	}

	@Test
	public void subCategoryPriceSortDSC() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "DSC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "DSC"));
	}

	@Test
	public void subCategoryPriceSortASC() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "ASC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}

	@Test
	public void subCategoryDiscountSorting() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.button_DiscountSort);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(ProductPages.getDiscountofproductsOncategorypage_Sort(driver, "DSC"));
	}

	@Test
	public void subsubCategoryDiscountFilter() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/banarasi-sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
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
	public void subsubCategoryPriceFilterFilter() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/banarasi-sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.applypricefilter0_500(driver);
		System.out.println("TEST");
		Assert.assertTrue(FiltersFlow.applyPriceFilter(driver, 0, 500));
		System.out.println("TEST");
	}

	@Test
	public void subsubCategoryPriceSortDSC() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/banarasi-sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "DSC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "DSC"));
	}

	@Test
	public void subsubCategoryPriceSortASC() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/banarasi-sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultMediumWait(driver);
		ProductPages.clickOnPriceSortingOnCategoryPage(driver, "ASC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnCategoryPage(driver, "ASC"));

	}

	@Test
	public void subsubCategoryDiscountSorting() {
		String url = read.getPropertyValue("url") + "womens-clothing/sarees/banarasi-sarees/";
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(url);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.button_DiscountSort);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(ProductPages.getDiscountofproductsOncategorypage_Sort(driver, "DSC"));
	}

	@Test
	public void colorfilteTestOnCategoryPage() {

		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.mousehover(driver, ObjectRepository_HomePage.megaMenu_salwarsuit);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.megamenu_Anarkali);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.FirstColorFromColorFilter_category);
		String prodcount = DriverActions.getText(driver, ObjectRepository_HomePage.span_totalProduct);
		//prodcount = prodcount.replace("PRODUCTS", "");
		prodcount = prodcount.trim();
		int prodcountint = Integer.parseInt(prodcount);
		if (prodcountint > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void recentlyViewedProductOnProductpage() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.mousehover(driver, ObjectRepository_HomePage.megaMenu_salwarsuit);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.megamenu_Anarkali);
		DriverActions.click(driver, ObjectRepository_HomePage.FirstProductFromCategory);
		Wait.defaultHighWait(driver);
		DriverActions.mousehover(driver, ObjectRepository_HomePage.megaMenu_salwarsuit);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.megamenu_Anarkali);
		Wait.defaultMediumWait(driver);
		driver.findElement(By.xpath(".//*[@id='listProducts']/div[1]/div[4]/div[1]/a/img")).click();
		DriverActions.scrollDownWindowTillpagination(driver);
		Assert.assertTrue(
				DriverActions.isElementDisplay(driver, ObjectRepository_HomePage.FirstProductFromRecentlyViewed));

	}

	@Test
	public void addToCartTestWithoutLogin() {
		boolean flag = true;
		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		try {

		} catch (AssertionError e) {
			flag = false;
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void feedpage_HomeBanner() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.click(driver, ObjectRepository_HomePage.Span_scrollingImages);
		Wait.defaultHighWait(driver);
		String count = DriverActions.getText(driver, ObjectRepository_HomePage.span_totalProduct);

		int productcount = Integer.parseInt(count);
		System.out.println("Count is " + productcount);
		if (productcount > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void pincodecheckOnPDPpage() {
		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(read.getPropertyValue("testproduct-url"));
		DriverActions.click(driver, ObjectRepository_HomePage.button_checkpincode);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_pincode, TestData.postcode_BillingInfo);
		DriverActions.click(driver, ObjectRepository_HomePage.button_submitpincode);
		Wait.defaultMediumWait(driver);
		String msg = DriverActions.getText(driver, ObjectRepository_HomePage.span_msgpinCheck);

		System.out.println("MSG is" + msg);

	}

	@Test
	public void paginationOnvendorPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.mousehover(driver, ObjectRepository_HomePage.megaMenu_salwarsuit);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.megamenu_Anarkali);
		DriverActions.click(driver, ObjectRepository_HomePage.firstVendortFromCategory);
		Wait.defaultMediumWait(driver);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.manage().window().maximize();
		driver.get(driver.getCurrentUrl());
		String prodname = DriverActions.getText(driver, ObjectRepository_HomePage.firstProductNameFromVendorPage);
		System.out.println("Product Name" + prodname);
		driver.findElement(By.id("vpp2")).click();
		String prodnamesecond = DriverActions.getText(driver, ObjectRepository_HomePage.firstProductNameFromVendorPage);
		System.out.println("Product Name" + prodnamesecond);
		if (prodname.equals(prodnamesecond)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}

		//driver.close();
		//driver.switchTo().window(tabs2.get(0));
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		Wait.defaultMediumWait(driver);

	}

	@Test
	public void paginationOnCategoryPageTest() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.mousehover(driver, ObjectRepository_HomePage.megaMenu_salwarsuit);
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.megamenu_Anarkali);

		Wait.defaultMediumWait(driver);
		String prodname = DriverActions.getText(driver, ObjectRepository_HomePage.FirstProductFromCategory);
		System.out.println("Product Name" + prodname);
		//DriverActions.scrollDownWindow(driver);
		WebElement element = driver.findElement(By.xpath(".//*[@id='main']/div/div[9]/h2"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		// actions.click();
		actions.perform();
		driver.findElement(By.id("cpp2")).click();
		String prodnamesecond = DriverActions.getText(driver, ObjectRepository_HomePage.FirstProductFromCategory);
		System.out.println("Product Name" + prodnamesecond);
		if (prodname.equals(prodnamesecond)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}

		//driver.close();
		//driver.switchTo().window(tabs2.get(0));
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		Wait.defaultMediumWait(driver);

	}

	@Test
	public void feedpage_HomeBanner_Sorting() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.click(driver, ObjectRepository_HomePage.Span_scrollingImages);
		Wait.defaultHighWait(driver);
		ProductPages.clickOnPriceSorting(driver, "ASC");
		Wait.defaultHighWait(driver);
		Assert.assertTrue(SortFlow.priceSortOnFeedPage(driver, "ASC"));

	}

	@Test
	public void cartIconFromHomepage() {
		driver = DriverSelector.getDriver_browserstacknew();
		DriverActions.click(driver, ObjectRepository_HomePage.Span_noofproductincart);
		Wait.defaultHighWait(driver);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("cart"));
		String actualmsg = DriverActions.getText(driver, ObjectRepository_HomePage.Span_cartempty);
		String expectedmsg = "YOUR CART IS EMPTY";
		Assert.assertEquals(actualmsg, expectedmsg);

	}

	@Test
	public void outOfStockMsgOnPDP() {
		driver = DriverSelector.getDriver_browserstacknew();
		String prod_id = read.getPropertyValue("OutOfStockProductid");
		String url = read.getPropertyValue("url") + "/catalog/product/view/id/"
				+ read.getPropertyValue("OutOfStockProductid")
				+ "/s/test?utm_medium=CVTEST&utm_source=CVTEST&utm_campaign=CVTEST";
		System.out.println("URL" + url);
		driver.get(url);
		Wait.defaultHighWait(driver);
		Assert.assertTrue(DriverActions.isElementDisplay(driver, ObjectRepository_HomePage.div_outOfStock));

	}

	@Test
	public void codNotAvailableMsgOnPDP() {
		driver = DriverSelector.getDriver_browserstacknew();
		String prod_id = read.getPropertyValue("OutOfStockProductid");
		String url = read.getPropertyValue("url") + "/catalog/product/view/id/"
				+ read.getPropertyValue("nonCODProductid")
				+ "/s/test?utm_medium=CVTEST&utm_source=CVTEST&utm_campaign=CVTEST";
		System.out.println("URL" + url);
		driver.get(url);
		Wait.defaultHighWait(driver);
		String msg = DriverActions.getText(driver, ObjectRepository_HomePage.div_CODNotAvailable);
		System.out.println("msg is " + msg);
		Assert.assertEquals(msg, "Cash on Delivery is not available.");
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();

	}

}

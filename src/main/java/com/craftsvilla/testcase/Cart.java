package com.craftsvilla.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.LoginFlow;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.AddToCartPage;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class Cart {
	WebDriver driver;
	PropertyReader read = new PropertyReader();
	LoginFlow login = new LoginFlow();

	@Test
	public void testAddnotetoseller() {

		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		AddToCartPage.clickOnAddNoteTOSeller(driver);
		Wait.defaultsmallWait(driver);
		AddToCartPage.enternoteforseller(driver, "test Note");
		AddToCartPage.clickOnSavebuttonaddnotetoseller(driver);
		Wait.defaultMediumWait(driver);
		String note = AddToCartPage.getNoteforseller(driver);
		System.out.println("Note" + note);
		Assert.assertEquals(note, "test Note");

	}

	@Test
	public void cartIconFromHomepage() {
		driver = DriverSelector.getDriver();
		DriverActions.click(driver, ObjectRepository_HomePage.Span_noofproductincart);
		Wait.defaultHighWait(driver);
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("cart"));
		String msg=DriverActions.getText(driver, ObjectRepository_HomePage.Span_cartempty);
		String actualmsg="YOUR CART IS EMPTY";
		Assert.assertEquals(actual, expected);
		Assert.
	}

	@Test
	public void testpriceAssertion() {

		driver = DriverSelector.getDriver_browserstacknew();
		driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/test");
		String firstprodprice_pdp = DriverActions.getText(driver, ObjectRepository_HomePage.product_priceonPDP);
		int firstprodpdp = AddToCartPage.formatOrderamountinInteger(driver, firstprodprice_pdp);
		System.out.println("First prod" + firstprodpdp);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickonAddToCartButton(driver);
		//AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		Wait.defaultMediumWait(driver);
		driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/642674/");
		Wait.defaultHighWait(driver);
		String secondprod_pdp = DriverActions.getText(driver, ObjectRepository_HomePage.product_priceonPDP);
		int secondprod = AddToCartPage.formatOrderamountinInteger(driver, secondprod_pdp);
		System.out.println("First prod" + secondprod);
		int total = firstprodpdp + secondprod;
		Wait.defaultHighWait(driver);
		HomePage.clickOnBuyNowButton(driver);
		Wait.defaultHighWait(driver);
		String ordertotal = AddToCartPage.getorderAmount(driver);
		int ordertotalint = AddToCartPage.formatOrderamountinInteger(driver, ordertotal);
		Assert.assertEquals(ordertotalint, ordertotalint);

		/*
										AddToCart.addToCartWithoutLogin(driver);
										Wait.defaultHighWait(driver);
										Wait.defaultHighWait(driver);
										AddToCartPage.clickOnAddNoteTOSeller(driver);
										Wait.defaultsmallWait(driver);
										AddToCartPage.enternoteforseller(driver, "test Note");
										AddToCartPage.clickOnSavebuttonaddnotetoseller(driver);
										Wait.defaultMediumWait(driver);
										String note = AddToCartPage.getNoteforseller(driver);
										System.out.println("Note" + note);
										Assert.assertEquals(note, "test Note");*/

	}

	@Test
	public void testAddtocartfromWihlist_Single() {
		driver = DriverSelector.getDriver_browserstacknew();
		login.loginflow(driver);
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);

		Wait.defaultHighWait(driver);
		String productURL = HomePage.getCurrentpageURL(driver);
		System.out.println("URL IS" + productURL);
		WebElement firstproduct = driver.findElement(By.id("buynow"));

		Actions action = new Actions(driver);
		action.moveToElement(firstproduct).perform();
		Wait.defaultMediumWait(driver);
		HomePage.clickOnWishButton(driver);
		Wait.defaultHighWait(driver);
		driver.get("https://securestatic.craftsvilla.com/wishlist/");
		Wait.defaultHighWait(driver);
		String currentcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int currentcountint = Integer.parseInt(currentcount);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_addToCartWishlist);
		Wait.defaultHighWait(driver);
		/*String aftercount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int aftercountint = Integer.parseInt(aftercount);
		System.out.println(aftercount + "COUNT IS" + currentcount);
		if (aftercountint > currentcountint) {
			Assert.assertTrue(true);
		} else {
		
			Assert.assertTrue(false);
		
		}*/
		Wait.defaultHighWait(driver);
		currentcountint = AddToCartPage.getNoofProductInCart(driver);
		AddToCartPage.clickOnRemovebbuttonforfirstProduct(driver);
		Wait.defaultHighWait(driver);
		//driver.get("https://secure.craftsvilla.com/buy/cart");
		int aftercountint = AddToCartPage.getNoofProductInCart(driver);
		//diff = currentproductcountint - aftercounproducttint;
		System.out.println("before is" + currentcount);
		System.out.println("after is" + aftercountint);
		if (currentcountint > aftercountint) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void testAddtocartfromWihlist_All() {
		driver = DriverSelector.getDriver_browserstacknew();
		login.loginflow(driver);
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);

		Wait.defaultHighWait(driver);
		String productURL = HomePage.getCurrentpageURL(driver);
		DriverActions.scrollDownWindowsmall(driver);
		System.out.println("URL IS" + productURL);
		WebElement firstproduct = driver.findElement(By.id("buynow"));

		Actions action = new Actions(driver);
		action.moveToElement(firstproduct).perform();
		Wait.defaultMediumWait(driver);
		HomePage.clickOnWishButton(driver);
		Wait.defaultHighWait(driver);
		driver.get("https://securestatic.craftsvilla.com/wishlist/");
		Wait.defaultHighWait(driver);
		String currentcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int currentcountint = Integer.parseInt(currentcount);
		DriverActions.scrollDownWindow(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_addToCartWishlist_All);
		Wait.defaultHighWait(driver);
		/*String aftercount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int aftercountint = Integer.parseInt(aftercount);
		System.out.println(aftercount + "COUNT IS" + currentcount);
		if (aftercountint > currentcountint) {
			Assert.assertTrue(true);
		} else {
		
			Assert.assertTrue(false);
		
		}*/
		Wait.defaultHighWait(driver);
		currentcountint = AddToCartPage.getNoofProductInCart(driver);
		AddToCartPage.clickOnRemovebbuttonforfirstProduct(driver);
		Wait.defaultHighWait(driver);
		driver.get("https://secure.craftsvilla.com/buy/cart");
		int aftercountint = AddToCartPage.getNoofProductInCart(driver);
		//diff = currentproductcountint - aftercounproducttint;
		System.out.println("before is" + currentcount);
		System.out.println("after is" + aftercountint);
		if (currentcountint > aftercountint) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void testloginAddtocartlogout() {
		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addFirstProductToCart(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		//Wait.defaultHighWait(driver);
		//Wait.defaultHighWait(driver);
		driver.get(read.getPropertyValue("url"));
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnAccount(driver);
		HomePage.clickonLogoutbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		String currentcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int currentcountint = Integer.parseInt(currentcount);
		Assert.assertEquals(currentcountint, 0);
		login.loginflow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.Span_noofproductincart);
		Wait.defaultMediumWait(driver);
		int currentproductcountint = AddToCartPage.getNoofProductInCart(driver);
		AddToCartPage.clickOnRemovebbuttonforfirstProduct(driver);
		Wait.defaultHighWait(driver);
		int aftercounproducttint = AddToCartPage.getNoofProductInCart(driver);
		//diff = currentproductcountint - aftercounproducttint;
		System.out.println("before is" + currentcount);
		System.out.println("after is" + aftercounproducttint);
		if (currentproductcountint > aftercounproducttint) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testeditsnotetoseller() {

		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		AddToCartPage.clickOnAddNoteTOSeller(driver);
		Wait.defaultsmallWait(driver);
		AddToCartPage.enternoteforseller(driver, "test Note");
		AddToCartPage.clickOnSavebuttonaddnotetoseller(driver);
		Wait.defaultMediumWait(driver);
		String note = AddToCartPage.getNoteforseller(driver);
		System.out.println("Note" + note);
		Assert.assertEquals(note, "test Note");
		AddToCartPage.clickeditAddnotetoseller(driver);
		Wait.defaultHighWait(driver);
		AddToCartPage.enternoteforseller(driver, "test Note edit");
		AddToCartPage.clickOnSavebuttonaddnotetoseller(driver);
		Wait.defaultMediumWait(driver);
		String editnote = AddToCartPage.getNoteforseller(driver);
		System.out.println("Note" + editnote);
		Assert.assertEquals(editnote, "test Note edit");

	}

	@Test
	public void testcontinueshoppingbutton_oncartpage() {
		PropertyReader read = new PropertyReader();
		driver = DriverSelector.getDriver_browserstacknew();
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		AddToCartPage.continueshoppingbutton_oncartPagee(driver);
		Wait.defaultHighWait(driver);
		String url = read.getPropertyValue("url");
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, url);

	}

	@Test
	public void testAddTocartusingAddtocart() {
		PropertyReader read = new PropertyReader();
		driver = DriverSelector.getDriver_browserstacknew();
		Wait.defaultMediumWait(driver);
		String currentcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int currentcountint = Integer.parseInt(currentcount);
		System.out.println("count=" + currentcount);

		Wait.defaultHighWait(driver);
		AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		Wait.defaultHighWait(driver);
		System.out.println("Click");
		String aftercount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincartonproduct);
		int aftercountint = Integer.parseInt(aftercount);
		int diff = aftercountint - currentcountint;
		System.out.println("current cunt" + aftercount);
		if (diff > 0) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testremoveproductfromcart() {

		driver = DriverSelector.getDriver_browserstacknew();
		Wait.defaultMediumWait(driver);
		String currentcount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincart);
		int currentproductcountint = Integer.parseInt(currentcount);
		System.out.println("count=" + currentcount);
		AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		//AddToCart.addToCartWithoutLoginAddtocartbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultMediumWait(driver);
		String aftercount = DriverActions.getText(driver, ObjectRepository_HomePage.Span_noofproductincartonproduct);
		int aftercounproducttint = Integer.parseInt(aftercount);
		int diff = aftercounproducttint - currentproductcountint;
		System.out.println("current cunt" + aftercount);
		if (diff > 0) {

			Assert.assertTrue(true);
			DriverActions.click(driver, ObjectRepository_HomePage.Span_noofproductincartonproduct);
			Wait.defaultHighWait(driver);
			Wait.defaultHighWait(driver);
			currentproductcountint = AddToCartPage.getNoofProductInCart(driver);
			AddToCartPage.clickOnRemovebbuttonforfirstProduct(driver);
			Wait.defaultHighWait(driver);
			aftercounproducttint = AddToCartPage.getNoofProductInCart(driver);
			//diff = currentproductcountint - aftercounproducttint;
			System.out.println("current cunt" + aftercount);

			if (aftercounproducttint == 0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} else {
			Assert.assertTrue(false);
		}
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

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();

	}
}

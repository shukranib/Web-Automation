package com.craftsvilla.testcase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.FiltersFlow;
import com.craftsvilla.commonflow.LoginFlow;
import com.craftsvilla.commonflow.WishListFlow;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.FailedTestCases;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;
import com.craftsvilla.pageObjects.TestData;
import com.craftsvilla.pageObjects.WishListPage;

public class WishList {
	WebDriver driver;
	PropertyReader read = new PropertyReader();

	@Test()

	public void testbackButtonOnnwishlistpage() {

		Boolean result;
		driver = DriverSelector.getDriver();
		String url = read.getPropertyValue("url");
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		// Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
		Wait.defaultHighWait(driver);
		System.out.println("Clicking on wishlist");
		HomePage.clickOnWishListbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		//Assert.assertTrue(driver.getCurrentUrl().equals(url + "/wishlist"));
		WishListPage.clickOnbackButtononwishlist(driver);
		System.out.println("Clicked");
		Wait.defaultHighWait(driver);
		result = (url.equals(driver.getCurrentUrl().trim()));
		Assert.assertTrue(result);

	}

	@Test()
	public void testforupdateWishList() {
		Boolean result;

		driver = DriverSelector.getDriver();
		String url = read.getPropertyValue("url");
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		// Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
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
		Wait.defaultHighWait(driver);

		System.out.println("Clicking on wishlist");
		HomePage.clickOnWishListbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		//Assert.assertTrue(driver.getCurrentUrl().equals(url + "/wishlist"));
		WishListPage.enterDescriptionInWishList(driver, "Test Wishlist");
		Wait.defaultMediumWait(driver);
		DriverActions.scrollDownhalfWindow(driver);
		Wait.defaultHighWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);
		Wait.defaultHighWait(driver);
		String text = DriverActions.getText(driver, ObjectRepository_HomePage.textArea_commentOnwishlistfirstproduct);
		result = text.equals("Test Wishlist");
		Assert.assertTrue(result);
		Wait.defaultHighWait(driver);
		int currentcountint = WishListPage.getproductcountinWishlistpage(driver);
		//Assert.assertTrue(driver.getCurrentUrl().equals(url + "/wishlist"));
		WishListPage.deleteFirstproduct_wishlist(driver);
		/*Wait.defaultMediumWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);*/
		Wait.defaultHighWait(driver);
		int aftercountint = WishListPage.getproductcountinWishlistpage(driver);
		int diff = currentcountint - aftercountint;
		if (diff == 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test()
	public void testdeletefirstproductfromWishList() {
		Boolean result;

		driver = DriverSelector.getDriver();
		String url = read.getPropertyValue("url");
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		// Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
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
		Wait.defaultHighWait(driver);

		System.out.println("Clicking on wishlist");

		HomePage.clickOnWishListbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		int beforecount = WishListPage.getproductcountinWishlistpage(driver);
		//Assert.assertTrue(driver.getCurrentUrl().equals(url + "/wishlist"));
		WishListPage.deleteFirstproduct_wishlist(driver);
		/*Wait.defaultMediumWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);*/
		Wait.defaultHighWait(driver);
		int aftercount = WishListPage.getproductcountinWishlistpage(driver);
		int diff = beforecount - aftercount;
		if (diff == 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test()
	public void testshareWishList() {
		Boolean result;

		driver = DriverSelector.getDriver();
		String url = read.getPropertyValue("url");
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		// Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
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
		Wait.defaultHighWait(driver);

		System.out.println("Clicking on wishlist");
		HomePage.clickOnWishListbutton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		WishListPage.enteremailforsharewishlist(driver, TestData.userNameLogin);
		WishListPage.entermessagesforshareWishlist(driver, "Test share email");
		WishListPage.clickOnShareWishListfinal(driver);
		Wait.defaultHighWait(driver);
		System.out.println("Message");
		String msg = DriverActions.getText(driver, ObjectRepository_HomePage.span_msgforsharewishlist);
		System.out.println("Message" + msg);
		Assert.assertEquals(msg, TestData.successMessage_sharewishlist);
		//Assert.assertTrue(driver.getCurrentUrl().equals(url + "/wishlist"));
		driver.get(read.getPropertyValue(url) + "/wishlist");
		Wait.defaultHighWait(driver);
		int beforecount = WishListPage.getproductcountinWishlistpage(driver);
		WishListPage.deleteFirstproduct_wishlist(driver);
		/*Wait.defaultMediumWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);*/
		Wait.defaultHighWait(driver);
		int aftercount = WishListPage.getproductcountinWishlistpage(driver);
		int diff = beforecount - aftercount;
		if (diff == 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test()
	public void addProductToWishlistTest() {
		boolean result;
		driver = DriverSelector.getDriver();
		result = WishListFlow.addToWishListAfterRegister(driver);
		Assert.assertTrue(result);

	}

	@Test()
	public void addProductToWishlistTestfromcategory() {
		boolean result;
		driver = DriverSelector.getDriver();
		//LoginFlow login = new LoginFlow();
		//result = login.loginflow(driver);
		FiltersFlow.gotosubcategory(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		WebElement firstproduct = driver.findElement(By.xpath(".//*[@id='product_data']/div[1]/div[1]/a/img"));

		Actions action = new Actions(driver);
		action.moveToElement(firstproduct).perform();
		//DriverActions.mousehover(driver, ObjectRepository_HomePage.FirstProductFromCategory);
		Wait.defaultsmallWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_wishiconforfirstproduct);
		Wait.defaultHighWait(driver);
		HomePage.EnterUserNameForLogin(driver);
		HomePage.enterPasswordForLogin(driver);
		HomePage.clickONSignInButton(driver);
		Wait.defaultHighWait(driver);
		driver.get("https://securestatic.craftsvilla.com/wishlist/");
		//Assert.assertTrue(result);
		Wait.defaultHighWait(driver);
		int beforecount = WishListPage.getproductcountinWishlistpage(driver);
		WishListPage.deleteFirstproduct_wishlist(driver);
		/*Wait.defaultMediumWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);*/
		Wait.defaultHighWait(driver);
		int aftercount = WishListPage.getproductcountinWishlistpage(driver);
		int diff = beforecount - aftercount;
		if (diff == 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test()
	public void testaddwishlistdate() {
		Boolean result;
		driver = DriverSelector.getDriver();
		String url = read.getPropertyValue("url");
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		// Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
		Wait.defaultHighWait(driver);
		System.out.println("Clicking on wishlist");
		HomePage.clickOnWishListbutton(driver);
		Wait.defaultHighWait(driver);
		String date = DriverActions.getText(driver, ObjectRepository_HomePage.span_addeddatewishlist);
		//String date1 = date.replace(",", " ");
		System.out.println(date);
		Date today;
		String output;
		SimpleDateFormat formatter;

		formatter = new SimpleDateFormat("MMM d, yyyy");
		today = new Date();
		output = formatter.format(today);
		System.out.println(output);
		if (output.equals(date)) {
			System.out.println("Matched");
		}
		Wait.defaultHighWait(driver);
		int beforecount = WishListPage.getproductcountinWishlistpage(driver);
		WishListPage.deleteFirstproduct_wishlist(driver);
		/*Wait.defaultMediumWait(driver);
		WishListPage.clickOnUpadateWishlist(driver);*/
		Wait.defaultHighWait(driver);
		int aftercount = WishListPage.getproductcountinWishlistpage(driver);
		int diff = beforecount - aftercount;
		if (diff == 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		/*	String msg = DriverActions.getText(driver, ObjectRepository_HomePage.span_msgforsharewishlist);
			System.out.println("Message" + msg);
			Assert.assertEquals(msg, TestData.successMessage_sharewishlist);*/
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			FailedTestCases.actionAfterFailedTestcase(driver, result);
		}
		driver.quit();

	}

}

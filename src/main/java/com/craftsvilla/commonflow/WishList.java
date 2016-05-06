package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class WishList {

	public static boolean addToWishListAfterRegister(WebDriver driver) {
		//LoginFlow login=new LoginFlow();
		Register.registerFlow(driver);
		HomePage.redirecttoHomePage(driver);
		//login.loginflow(driver);
		HomePage.clickOnFistCategory(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);

		Wait.defaultHighWait(driver);
		String productURL = HomePage.getCurrentpageURL(driver);
		System.out.println("URL IS"+productURL);
		HomePage.clickOnWishButton(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnAccount(driver);
		HomePage.clickOnManageAccount(driver);
		HomePage.clickOnWishListFromManageAccount(driver);
		// Screenshot.takeScreenshot(driver, "AfterClickingOnManaageAccount");
		Wait.defaultMediumWait(driver);
		HomePage.openFirstProductFromWishList(driver);
		String wishlistproductURl = HomePage.getCurrentpageURL(driver);
		System.out.println("URL IS"+wishlistproductURl);
		if(wishlistproductURl.replace('/', ' ').trim().equals(productURL.replace('/', ' ').trim()))
		{
			
			return true;
		}
		return false;
	}

	public static boolean addToWishListFromHomePage(WebDriver driver) {

		Register.registerFlow(driver);
		HomePage.redirecttoHomePage(driver);
		HomePage.clickOnFistCategory(driver);
		HomePage.clickOnFirstProduct(driver);

		Wait.defaultHighWait(driver);
		String productURL = HomePage.getCurrentpageURL(driver);
		HomePage.clickOnWishButton(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnAccount(driver);
		HomePage.clickOnManageAccount(driver);
		HomePage.clickOnWishListFromManageAccount(driver);
		HomePage.openFirstProductFromWishList(driver);
		String wishlistproductURl = HomePage.getCurrentpageURL(driver);
		if (productURL.equals(wishlistproductURl)) {
			return true;
		}
		return false;
	}
}

package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class WishList {

	public static boolean addToWishListAfterRegister(WebDriver driver) {
		//LoginFlow login=new LoginFlow();
		Register.registerFlow(driver);
		HomePage.redirecttoHomePage(driver);
		//login.loginflow(driver);
		driver.get("http://www.craftsvilla.com/womens-clothing/salwar-suits/");
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);

		Wait.defaultHighWait(driver);
		String productURL = HomePage.getCurrentpageURL(driver);
		System.out.println("URL IS"+productURL);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_addToCart);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnWishButton(driver);
		Wait.defaultMediumWait(driver);
		/*HomePage.clickOnAccount(driver);
		HomePage.clickOnManageAccount(driver);*/
		Wait.defaultMediumWait(driver);
		driver.get("https://securestatic.craftsvilla.com/wishlist/");
		//HomePage.clickOnWishListFromManageAccount(driver);
		// Screenshot.takeScreenshot(driver, "AfterClickingOnManaageAccount");
		Wait.defaultHighWait(driver);
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

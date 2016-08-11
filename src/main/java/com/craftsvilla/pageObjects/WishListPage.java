package com.craftsvilla.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;

public class WishListPage {
	public static void clickOnUpadateWishlist(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_updateWishList);

	}

	public static void clickOnbackButtononwishlist(WebDriver driver) {

		DriverActions.click(driver, ObjectRepository_HomePage.Link_backWishList);
	}

	public static void enterDescriptionInWishList(WebDriver driver, String desc) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textArea_commentOnwishlistfirstproduct, desc);
	}

	public static void clickOnShareWishList(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_shareWishlist);
	}

	public static void enteremailforsharewishlist(WebDriver driver, String email) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textArea_emailOnsharewishlist, email);
	}

	public static void clickOnShareWishListfinal(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_shareWishlistfinal);
	}

	public static void entermessagesforshareWishlist(WebDriver driver, String msg) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textarea_messagesharewishlist, msg);
	}

	public static int getproductcountinWishlistpage(WebDriver driver) {
		List<WebElement> wishedproduct = DriverActions.findElements(driver,
				ObjectRepository_HomePage.row_productwishlist);

		int count = wishedproduct.size();
		return count;
	}

	public static void deleteFirstproduct_wishlist(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_deletefirstproductformwishlist);
		Wait.defaultMediumWait(driver);
		DriverActions.clickOnOkButtonForPopUp(driver);

	}

}

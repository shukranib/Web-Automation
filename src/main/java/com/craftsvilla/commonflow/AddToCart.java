package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class AddToCart {
	public static void addFirstProductToCart(WebDriver driver) {
		LoginFlow login = new LoginFlow();
		login.loginflow(driver);
		Wait.defaultHighWait(driver);
		
		HomePage.clickOnFistCategory(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.checkOnlyCODProduct(driver);
		Wait.defaultMediumWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);
		Wait.defaultMediumWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnBuyNowButton(driver);
		
	}

	public static void addToCartWithoutLogin(WebDriver driver) {
		HomePage.clickOnFistCategory(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.checkOnlyCODProduct(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnBuyNowButton(driver);
		String cartMessage=HomePage.getmessage(driver);
		System.out.println("Cart message"+cartMessage);
	}
	
}

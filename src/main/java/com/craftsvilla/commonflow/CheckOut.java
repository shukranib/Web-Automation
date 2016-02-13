package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;

public class CheckOut {
	public static void CODOrderPlaceAfterRegister(WebDriver driver) {
		Register.registerFlow(driver);
		HomePage.redirecttoHomePage(driver);
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
		CommonFunctionRepo.enterBillingAddress(driver);
		HomePage.clickOnContinueButton(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);

	}
	public static void codOrderPlaceAddtoCartThenregister(WebDriver driver) {
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
	
		CheckOutPage.chooseNewCustomerOption(driver);
		
		CommonFunctionRepo.enterBillingAddressGuest(driver);
		HomePage.clickOnContinueButton(driver);
		Wait.defaultMediumWait(driver);
		// HomePage.clickOnCODPaymentMethod(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);
		
		

	}
	public static void codOrderAfterLogin(WebDriver driver)
	{
		AddToCart.addFirstProductToCart(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnContinueButton(driver);
		Wait.defaultMediumWait(driver);
		// HomePage.clickOnCODPaymentMethod(driver);
		CommonFunctionRepo.enterBillingAddress(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);
		
	}

	public static void PrePaymentOrderPlace(WebDriver driver) {

	}
}

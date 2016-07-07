package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.OrderHistoryPage;
import com.craftsvilla.pageObjects.PaymentPage;

public class CheckOut {
	
	public static void CODOrderPlaceAfterRegister(WebDriver driver) {
		Register.registerFlow(driver);
		HomePage.redirecttoHomePage(driver);
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		String productName="TEST";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
		
		Wait.defaultHighWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		System.out.println("Clicked");
		Wait.defaultHighWait(driver);
		CommonFunctionRepo.enterBillingAddress(driver);
		HomePage.clickOnContinueButton(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnCODPaymentMethod(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);
		cancelFirstOrderFromOrderHistory(driver,productName);

	}
	public static void cancelFirstOrderFromOrderHistory(WebDriver driver,String productName)
	{
		Wait.defaultHighWait(driver);
		OrderHistoryPage.gotoconfirmedOrderPage(driver);
		Wait.defaultMediumWait(driver);
		//OrderHistoryPage.clickOnExpandButtonForOrderDetails(driver);
		//Wait.defaultMediumWait(driver);
		//String productNameOrdeHistory=OrderHistoryPage.getOrderProductNameOrderHistory(driver);
		//Wait.defaultMediumWait(driver);
		//if (!productNameOrdeHistory.equalsIgnoreCase(productName)) {
			//System.out.println("Wrong Product Shown");
		//}
		OrderHistoryPage.clickOnCancelButtonForOrderDetails(driver);
		Wait.defaultMediumWait(driver);
		DriverActions.clickOnOkButtonForPopUp(driver);
		Wait.defaultMediumWait(driver);
		System.out.println("Order has been cancelled successfully");
		//Wait.defaultsmallWait(driver);
		
	}
	public static void codOrderPlaceAddtoCartThenregister(WebDriver driver) {
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		String productName=CheckOutPage.getProductNameOnOrderHistoryPage(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
	
		//CheckOutPage.chooseNewCustomerOption(driver);
		
		CommonFunctionRepo.enterBillingAddressGuest(driver);
		HomePage.clickOnContinueButton(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnCODPaymentMethod(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);
		
		cancelFirstOrderFromOrderHistory(driver, productName);

	}
	public static void codOrderAfterLogin(WebDriver driver)
	{
		AddToCart.addFirstProductToCart(driver);
		Wait.defaultMediumWait(driver);
		String productName="TEST";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
		Wait.defaultsmallWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
		
		CheckOutPage.clickOnDeliverToThisAddressButton(driver);
		Wait.defaultHighWait(driver);
		CheckOutPage.clickOnCODOrderPlace(driver);
		/*cancelFirstOrderFromOrderHistory(driver, productName);
		CheckOutPage.clickOnLoginHereButton(driver);
		Wait.defaultMediumWait(driver);
		HomePage.EnterUserNameForLogin(driver);
		Wait.defaultsmallWait(driver);
		HomePage.enterPasswordForLogin(driver);
		HomePage.clickONSignInButton(driver);
		Wait.defaultMediumWait(driver);*/
		// HomePage.clickOnCODPaymentMethod(driver);
		//CommonFunctionRepo.enterBillingAddress(driver);
	
		//cancelFirstOrderFromOrderHistory(driver, productName);
		
	}
public static void codOrderPlaceGuestCheckout(WebDriver  driver)
{
	//System.out.println("Method Called");
	AddToCart.addToCartWithoutLogin(driver);
	Wait.defaultHighWait(driver);
	String productName="Test";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
	Wait.defaultHighWait(driver);
	HomePage.clickOnProceedToPaymentButton(driver);
	Wait.defaultHighWait(driver);
	DriverActions.scrollDownWindow(driver);
	Wait.defaultHighWait(driver);
	CheckOutPage.clickOncontinueAsGuestButton(driver);
	Wait.defaultHighWait(driver);
	CheckOutPage.enterEmailIdForGuestCheckout(driver);
	CheckOutPage.clickOnGuestCheckout(driver);
	Wait.defaultHighWait(driver);
	CommonFunctionRepo.enterBillingAddressGuest(driver);
	Wait.defaultMediumWait(driver);
	CheckOutPage.clickOnsaveAndContinueGuest(driver);
	//CheckOutPage.clickOnDeliverToThisAddressButton(driver);
	Wait.defaultHighWait(driver);
	
	CheckOutPage.clickOnCODOrderPlace(driver);
	Wait.defaultMediumWait(driver);
	//cancelFirstOrderFromOrderHistory(driver, productName);
}
	public static void PrePaymentOrderPlace(WebDriver driver) {
		
		//System.out.println("Method Called");
		AddToCart.addToCartWithoutLogin(driver);
		Wait.defaultHighWait(driver);
		String productName="Test";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnProceedToPaymentButton(driver);
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		CheckOutPage.clickOncontinueAsGuestButton(driver);
		Wait.defaultHighWait(driver);
		CheckOutPage.enterEmailIdForGuestCheckout(driver);
		CheckOutPage.clickOnGuestCheckout(driver);
		Wait.defaultHighWait(driver);
		CommonFunctionRepo.enterBillingAddressGuest(driver);
		Wait.defaultMediumWait(driver);
		CheckOutPage.clickOnsaveAndContinueGuest(driver);
		//CheckOutPage.clickOnDeliverToThisAddressButton(driver);
		Wait.defaultHighWait(driver);
		PaymentPage.click_On_DebitCardOption(driver);
		Wait.defaultMediumWait(driver);
		CommonFunctionRepo.enterDetailsForDebitPayments(driver);
		Wait.defaultsmallWait(driver);
		CheckOutPage.clickOnCODOrderPlace(driver);
	}
}

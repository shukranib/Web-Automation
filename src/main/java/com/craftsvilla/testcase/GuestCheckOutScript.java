package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.craftsvilla.commonflow.AddToCart;
import com.craftsvilla.commonflow.LoginFlow;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.CheckOutPage;
import com.craftsvilla.pageObjects.CommonFunctionRepo;
import com.craftsvilla.pageObjects.HomePage;

public class GuestCheckOutScript {
	WebDriver driver;

	@Test(enabled = false)
	public void guestCheckOutScript() {
		for (int i = 0; i < 4; i++) {
			driver = DriverSelector.getDriver_browserstacknew();
			AddToCart.addToCartWithoutLogin(driver);
			Wait.defaultHighWait(driver);
			String productName = "Test";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
			Wait.defaultHighWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			Wait.defaultHighWait(driver);
			DriverActions.scrollDownWindow(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.clickOncontinueAsGuestButton(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.enterEmailIdForGuestCheckout(driver, "Testemail5@gmail.com");
			CheckOutPage.clickOnGuestCheckout(driver);
			Wait.defaultHighWait(driver);
			CommonFunctionRepo.enterBillingAddressGuest(driver);
			Wait.defaultMediumWait(driver);
			CheckOutPage.clickOnsaveAndContinueGuest(driver);
			//CheckOutPage.clickOnDeliverToThisAddressButton(driver);
			Wait.defaultHighWait(driver);

			CheckOutPage.clickOnCODOrderPlace(driver);
			Wait.defaultMediumWait(driver);

			Wait.defaultHighWait(driver);
			String ordername = DriverActions.getText(driver, "Span_orderId");
			System.out.println("RESULT==" + ordername);
			Screenshot.takeScreenshot(driver);
			driver.quit();
		}
	}

	@Test
	public void loginCheckOutScript() {
		//for(int i=0;i<11;i++)
		//{
		LoginFlow login = new LoginFlow();
		for (int i = 0; i < 5; i++) {
			driver = DriverSelector.getDriver_browserstacknew();
			//CheckOut.codOrderAfterLogin(driver);
			login.loginflow(driver, "testAuto@gmail.com", "123456");
			AddToCart.addToCartWithoutLogin(driver);
			Wait.defaultMediumWait(driver);
			String productName = "TEST";//CheckOutPage.getProductNameOnOrderHistoryPage(driver);
			Wait.defaultsmallWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			Wait.defaultHighWait(driver);

			CheckOutPage.clickOnDeliverToThisAddressButton(driver);
			Wait.defaultHighWait(driver);
			CheckOutPage.clickOnCODOrderPlace(driver);
			Wait.defaultHighWait(driver);
			String ordername = DriverActions.getText(driver, "Span_orderId");
			System.out.println("RESULT==" + ordername);
			Screenshot.takeScreenshot(driver);
			driver.quit();
			//}
		}
	}
}

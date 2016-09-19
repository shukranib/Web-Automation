package commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;

import pageObjects.CommonFunctionRepo;
import pageObjects.HomePage;

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
		Wait.defaultMediumWait(driver);
		// HomePage.clickOnCODPaymentMethod(driver);
		HomePage.clickOnPlaceOrder(driver);
		Wait.defaultMediumWait(driver);

	}

	public static void PrePaymentOrderPlace(WebDriver driver) {

	}
}

package com.craftsvilla.pageObjects;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;

public class CheckOutPage {
	static public void chooseNewCustomerOption(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.checkBox_newCustomer);
	}

	static public void chooseExistingCustomerOption(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.CheckBox_existingCustomer);
	}

	public static void enterFirstName_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_firstNameBillingInfo,
				TestData.firstNameBillingInfo);
	}

	public static void enterTelephoneNumber_shippingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.Shipping_textBox_mobileNo, TestData.mobileNo);
	}

	public static void enterLastName_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_lastNameBillingInfo,
				TestData.lastName_BillingInfo);
	}

	public static void clickOnsaveAndContinueGuest(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_saveAndContinueGuest);
	}

	public static void enterstreet1_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_street1BillingInfo,
				TestData.street1_BillingInfo);
		CheckOutPage.enterLastName_BillingInfo(driver);

	}

	public static void enterAddress_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_shippingAdress,
				TestData.street1_BillingInfo + TestData.street2_BillingInfo);

	}

	public static void clickOncontinueAsGuestButton(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_continueAsGuest);

	}

	public static void clickOnGuestCheckout(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_guestCheckout);
	}

	public static void clickOnCODOrderPlace(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_placeOrderCOD);
	}

	public static void clickOnDeliverToThisAddressButton(WebDriver driver) {
		Wait.defaultHighWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_deliverToThisAddress);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_loginDeliverToThisAddress);
	}

	public static void enterEmailIdForGuestCheckout(WebDriver driver) {
		String userEmail = TestData.emailIdRegister + new Date().getTime() + "@gmail.com";
		Log4jLogger.writeErrorLog("New register Email" + userEmail);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_emaildForGuest, userEmail);
	}

	public static void enterEmailIdForGuestCheckout(WebDriver driver, String email) {

		Log4jLogger.writeErrorLog("New register Email" + email);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_emaildForGuest, email);
	}

	public static void enterstreet2_BilligInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_street2BilligInfo,
				TestData.street2_BillingInfo);
	}

	public static void entercity_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_cityBilligInfo, TestData.city_BillingInfo);
	}

	public static void enterpostcode_BillingInfo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_postcodeBilligInfo,
				TestData.postcode_BillingInfo);
	}

	public static void entercountry_BillingInfo(WebDriver driver) {
		// Select country=new Select(element)
		DriverActions.selectByvisibleText(driver, ObjectRepository_HomePage.ListBox_countryBilligInfo,
				TestData.country_BillingInfo);
	}

	public static void enterregoin_BillingInfo(WebDriver driver) {
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.ListBox_regoinBilligInfo);
		DriverActions.selectByvisibleText(driver, ObjectRepository_HomePage.ListBox_regoinBilligInfo,
				TestData.regoin_BillingInfo);
	}

	public static void entertelephone_BillingInfo(WebDriver driver) {
		Random rand = new Random();
		int number = rand.nextInt(1000) + 1;

		String no = "1111111" + Integer.toString(number);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.Shipping_textBox_mobileNo, no);
	}

	public static void enterEmailForguestcheckout(WebDriver driver) {
		String userEmail = TestData.emailIdRegister + new Date().getTime() + "@gmail.com";
		System.out.println("Regiser" + userEmail);
		Log4jLogger.writeErrorLog("New register Email" + userEmail);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_emailIdforbilling, userEmail);
	}

	public static String getProductNameOnOrderHistoryPage(WebDriver driver) {
		String productName = DriverActions.getText(driver, ObjectRepository_HomePage.product_nameOnOrdeSummaryPage);
		return productName;
	}

	public static void clickOnLoginHereButton(WebDriver driver) {
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.Button_loginHere);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_loginHere);

	}

	public static void clickOnDebitCardOrderPlace(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.click(driver, ObjectRepository_HomePage.button_paySecurly);
	}
}

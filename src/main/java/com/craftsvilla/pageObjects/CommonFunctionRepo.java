package com.craftsvilla.pageObjects;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;

public class CommonFunctionRepo {
	public static void clickOnCategory(WebDriver driver, String linkText) {
		DriverActions.clickByLinkText(driver, linkText);

	}

	public static void enterBillingAddress(WebDriver driver) {
		CheckOutPage.enterFirstName_BillingInfo(driver);
		CheckOutPage.enterLastName_BillingInfo(driver);
		CheckOutPage.enterAddress_BillingInfo(driver);
		//CheckOutPage.enterstreet1_BillingInfo(driver);
		//CheckOutPage.enterEmailForguestcheckout(driver);
		//CheckOutPage.enterstreet2_BilligInfo(driver);
		DriverActions.scrollDownWindow(driver);
		//CheckOutPage.entercity_BillingInfo(driver);
		CheckOutPage.enterpostcode_BillingInfo(driver);
		//CheckOutPage.entercountry_BillingInfo(driver);
		Wait.defaultMediumWait(driver);
		CheckOutPage.enterregoin_BillingInfo(driver);
		CheckOutPage.entertelephone_BillingInfo(driver);

	}
	public static void enterDetailsForDebitPayments(WebDriver driver) {
	PaymentPage.enterDebitCardNo(driver);
	Wait.defaultMediumWait(driver);
	PaymentPage.enterDebitCardName(driver);
	Wait.defaultMediumWait(driver);
	PaymentPage.enterDebitCardExpiraryMonth(driver);
	Wait.defaultMediumWait(driver);
	PaymentPage.enterDebitCardExpiraryYear(driver);
	Wait.defaultMediumWait(driver);
	PaymentPage.enterDebitCardCsvNo(driver);

	}
	public static void enterBillingAddressGuest(WebDriver driver) {
		CheckOutPage.enterFirstName_BillingInfo(driver);
		CheckOutPage.enterLastName_BillingInfo(driver);
		CheckOutPage.enterAddress_BillingInfo(driver);
		DriverActions.scrollDownhalfWindow(driver);
		CheckOutPage.enterpostcode_BillingInfo(driver);
		Wait.defaultMediumWait(driver);
		CheckOutPage.entertelephone_BillingInfo(driver);
		
	}
}

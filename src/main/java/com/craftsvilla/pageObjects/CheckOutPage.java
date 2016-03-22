package com.craftsvilla.pageObjects;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;

public class CheckOutPage {
static public void chooseNewCustomerOption(WebDriver driver)
{
	DriverActions.click(driver, ObjectRepository_HomePage.checkBox_newCustomer);
}
static public void chooseExistingCustomerOption(WebDriver driver)
{
	DriverActions.click(driver, ObjectRepository_HomePage.CheckBox_existingCustomer);
}
public static void enterFirstName_BillingInfo(WebDriver driver) {
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_firstNameBillingInfo,
			TestData.firstNameBillingInfo);
}

public static void enterLastName_BillingInfo(WebDriver driver) {
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_lastNameBillingInfo,
			TestData.lastName_BillingInfo);
}

public static void enterstreet1_BillingInfo(WebDriver driver) {
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_street1BillingInfo,
			TestData.street1_BillingInfo);
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
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_telephoneBillIngInfo,
			TestData.telephone_BillingInfo);
}
public static void enterEmailForguestcheckout(WebDriver driver)
{
	String userEmail = TestData.emailIdRegister + new Date().getTime() + "@gmail.com";
	System.out.println("Regiser"+userEmail);
	Log4jLogger.writeErrorLog("New register Email" + userEmail);
	DriverActions.sendKeys(driver,ObjectRepository_HomePage.textBox_emailIdforbilling,userEmail);
}
public static String getProductNameOnOrderHistoryPage(WebDriver driver)
{
	String productName=DriverActions.getText(driver, ObjectRepository_HomePage.product_nameOnOrdeSummaryPage);
	return productName;
}
public static void clickOnLoginHereButton(WebDriver driver)
{
	DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.Button_loginHere);
	DriverActions.click(driver, ObjectRepository_HomePage.Button_loginHere);
	
}
}

package com.craftsvilla.pageObjects;
import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;
public class PaymentPage {
public static void click_On_DebitCardOption(WebDriver driver)
{
	DriverActions.click(driver, ObjectRepository_HomePage.Button_DebitCard);
	
}
public static void enterDebitCardNo(WebDriver driver)
{
	
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_DebitCardNo, TestData.debitCardNo);
}
public static void enterDebitCardName(WebDriver driver)
{
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_DebitCardName, TestData.debitCardName);
	
}
public static void enterDebitCardCsvNo(WebDriver driver)
{
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_DebitCardCSV, TestData.debitCardCsvNo);
}
public static void enterDebitCardExpiraryMonth(WebDriver driver)
	{
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_DebitCardExpMonth, TestData.debitCardExpiraryMonth);
	}
public static void enterDebitCardExpiraryYear(WebDriver driver)
{
	DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_DebitCardexpYear, TestData.debitCardExpiraryYear);
}

}

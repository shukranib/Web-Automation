package com.craftsvilla.pageObjects;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;

public class OrderHistoryPage {
	static	PropertyReader read=new PropertyReader();
		public static void gotoconfirmedOrderPage(WebDriver driver)
		{
			Wait.defaultHighWait(driver);
			driver.get(read.getPropertyValue("url").concat("sales/order/history/"));
			Wait.defaultHighWait(driver);
		}

		public static String getOrderProductNameOrderHistory(WebDriver driver)
		{
			Wait.defaultHighWait(driver);
			String productName=	DriverActions.getText(driver, ObjectRepository_HomePage.product_nameOnOrderHistoryPage);
			Wait.defaultHighWait(driver);
			return productName;
		}
		public static void clickOnExpandButtonForOrderDetails(
				WebDriver driver) {
			// TODO Auto-generated method stub
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.expand_buttonOnForOrder);
			DriverActions.click(driver, ObjectRepository_HomePage.expand_buttonOnForOrder);
			Wait.defaultMediumWait(driver);
		}
		public static void clickOnCancelButtonForOrderDetails(
				WebDriver driver) {
			// TODO Auto-generated method stub
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.cancelButton_OrderhistoryPage);
			DriverActions.click(driver, ObjectRepository_HomePage.cancelButton_OrderhistoryPage);
			Wait.defaultMediumWait(driver);
		}
}

package com.craftsvilla.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;

public class AddToCartPage {

	public static void clickOnAddNoteTOSeller(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_addToNotetoseller);
	}

	public static void increaseOrdecreasequantity(WebDriver driver, String quantity) {
		DriverActions.selectByvisibleText(driver, ObjectRepository_HomePage.select_Quantityforfirstproduct, quantity);

	}

	public static void clickOnCancelButtonforAddnotetoseller(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_cancelnteforseller);
	}

	public static int formatOrderamountinInteger(WebDriver driver, String amt) {
		int price;
		if (amt.contains(",")) {
			StringBuffer formattedvaluebuffer = new StringBuffer(amt);
			int pos = formattedvaluebuffer.indexOf(",");
			while (pos != -1) {
				formattedvaluebuffer.deleteCharAt(pos);
				pos = formattedvaluebuffer.indexOf(",");

			}
			price = Integer.parseInt(formattedvaluebuffer.toString());

		} else {
			price = Integer.parseInt(amt);

		}
		return price;
	}

	public static void clickOnSavebuttonaddnotetoseller(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_saveNotetoseller);
	}

	public static void clickOnRemovebbuttonforfirstProduct(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_removefirstproductfromcart);
	}

	public static void clickeditAddnotetoseller(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_editnotetoseller);
	}

	public static int getNoofProductInCart(WebDriver driver) {
		List<WebElement> cartproduct = DriverActions.findElements(driver,
				ObjectRepository_HomePage.div_productfromcart);
		int totalproduct = cartproduct.size();
		System.out.println("current product in cart " + totalproduct);
		return totalproduct;
	}

	public static String getorderAmount(WebDriver driver) {
		String amount = DriverActions.getText(driver, ObjectRepository_HomePage.div_totalorderamountoncartpage);
		return amount;
	}

	public static void enternoteforseller(WebDriver driver, String note) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textArea_messageaddntetoseller);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textArea_messageaddntetoseller, note);
	}

	public static String getNoteforseller(WebDriver driver) {
		String msg = DriverActions.getText(driver, ObjectRepository_HomePage.span_notetosellerfirstproduct);
		return msg;
	}

	public static void continueshoppingbutton_oncartPagee(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_continueshoppingoncart);
	}
}

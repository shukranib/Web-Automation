package com.craftsvilla.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;

public class ProductPages {

	public static void applypricefilter500_1000(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "500Price");
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_500_1000);
		DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_500_1000);

	}

	public static void applypricefilter500_1000OnSearchPage(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "500Price");
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_500_1000);
		// DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_500_1000);

	}

	public static void applypricefilter1000_2000(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "1000Price");
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);
		DriverActions.scrollDownWindow(driver);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

	}

	public static void applypricefilter1000_2000OnsearchPage(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "1000Price");
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

	}

	public static void applypricefilter2000_5000(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_2000_5000);
	}

	public static void applypricefilter2000_5000OnsearchPage(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

	}

	public static void applyPriceFilterAbove5000(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_above5000);
	}

	public static void applyPriceFilterAbove5000OnSearchPage(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_above5000);
	}

	public static boolean getPriceofproductsOncategorypage(WebDriver driver, int min, int max) {

		List<WebElement> productsprice = DriverActions.findElements(driver, ObjectRepository_HomePage.productprice);
		List<Integer> intproductprice = new ArrayList<>();
		int price;
		for (int i = 0; i < productsprice.size(); i++) {
			String formattedvalue = productsprice.get(i).getText();
			if (formattedvalue.contains(",")) {
				StringBuffer formattedvaluebuffer = new StringBuffer(formattedvalue);
				int pos = formattedvaluebuffer.indexOf(",");
				while (pos != -1) {
					formattedvaluebuffer.deleteCharAt(pos);
					pos = formattedvaluebuffer.indexOf(",");

				}
				price = Integer.parseInt(formattedvaluebuffer.toString());
				intproductprice.add(price);
			} else {
				price = Integer.parseInt(formattedvalue);
				intproductprice.add(price);
			}
		}
		for (int i = 0; i < intproductprice.size(); i++) {
			if (min == 5000) {
				if (intproductprice.get(i) < min) {
					Log4jLogger.writeErrorLog("Invalid price product" + intproductprice.get(i));
					Log4jLogger.writeErrorLog("Price filter Not Working for above" + min);
					return false;
				}
			} else {
				if (intproductprice.get(i) < min || intproductprice.get(i) > max) {
					Log4jLogger.writeErrorLog("Invalid price product" + intproductprice.get(i));
					Log4jLogger.writeErrorLog("Price filter Not Working for" + min + "To" + max);
					return false;
				}
			}
		}
		return true;

	}

	public static void applypricefilter0_500(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_0_500);
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_0_500);
	}

	public static void applypricefilter0_500OnSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_0_500);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_0_500);
	}

}

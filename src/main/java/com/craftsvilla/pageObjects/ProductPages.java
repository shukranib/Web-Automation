package com.craftsvilla.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;

public class ProductPages {

	public static void applypricefilter500_1000(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_500_1000);

	}

	public static void applypricefilter1000_2000(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);
		WebElement element = driver.findElement(By.xpath(".//*[@value='1000_2000']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		// DriverActions.click(driver,
		// ObjectRepository_HomePage.PriceFilter_1000_2000);
	}

	public static void applypricefilter2000_5000(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_2000_5000);
	}

	public static void applyPriceFilterAbove5000(WebDriver driver) {
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
			if (intproductprice.get(i) < min || intproductprice.get(i) > max) {
				Log4jLogger.writeErrorLog("Invalid price product" + intproductprice.get(i));
				Log4jLogger.writeErrorLog("Price filter Not Working for" + min + "To" + max);
				return false;
			}

		}
		return true;

	}

}

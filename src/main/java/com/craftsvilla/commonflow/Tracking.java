package com.craftsvilla.commonflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class Tracking {
	static PropertyReader read = new PropertyReader();
	//static WebDriver driver = DriverSelector.getDriver();

	public static String return_pageName(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object pageName = js.executeScript("return digitalData.page.pageInfo.pageName;");
		System.out.println("PageName" + pageName);

		return pageName.toString();

	}

	public static boolean testAddtocart_MIDtracking(WebDriver driver) {

		Wait.defaultHighWait(driver);
		System.out.println("Driver created");

		Wait.defaultHighWait(driver);
		WebElement addtocart = DriverActions.findElement(driver, ObjectRepository_HomePage.Button_addToCart);
		String onclickfunction = addtocart.getAttribute("onclick");
		System.out.println("ONCLICK" + onclickfunction);

		if (onclickfunction.contains("addtocartTracker")) {
			System.out.println("Add to Cart Working properly");
			return true;
		}
		return false;

	}

	public static boolean testBuynow_MIDtracking(WebDriver driver) {

		Wait.defaultHighWait(driver);
		WebElement addtocart = DriverActions.findElement(driver, ObjectRepository_HomePage.button_buyNow);
		String onclickfunction = addtocart.getAttribute("onclick");
		System.out.println("ONCLICK" + onclickfunction);
		if (onclickfunction.contains("buyNowTracker")) {
			System.out.println("INSIDE TRUE");
			System.out.println("Buy Now Working properly");
			return true;
		}
		return false;

	}

	public static String return_deviceType(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object deviceType = js.executeScript("return digitalData.page.device.deviceType");
		System.out.println("Device type is " + deviceType);

		return deviceType.toString();

	}

	public static String return_pageType(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object pageType = js.executeScript("return digitalData.page.category.pageType;");
		System.out.println("Page Name is" + pageType);

		return pageType.toString();

	}

	public static boolean getscripttag(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> scripts = driver.findElements(By.tagName("script"));
		int size = scripts.size();

		System.out.println(size);
		for (int i = 0; i < size; i++) {
			String url = scripts.get(i).getAttribute("src");

			if (url.contains("satellite")) {
				System.out.println("TRUE");
				System.out.println(url);
				return true;
			}
		}
		return false;
	}

	public static String getvalue(WebDriver driver, String jsvariable) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object value = js.executeScript("return " + jsvariable + ";");

		System.out.println(jsvariable + "\t" + value);

		return value.toString();
	}

}

package com.craftsvilla.commonflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class AddToCart {
	static LoginFlow login = new LoginFlow();
	static PropertyReader read = new PropertyReader();

	public static void addFirstProductToCart(WebDriver driver) {

		login.loginflow(driver);
		Wait.defaultHighWait(driver);
		driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/self-red");
		//http://www.craftsvilla.com/catalog/product/view/id/4331545/s/test
		/*HomePage.clickOnFistCategory(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.checkOnlyCODProduct(driver);
		Wait.defaultMediumWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);
		Wait.defaultMediumWait(driver);
		*/
		Wait.defaultHighWait(driver);
		HomePage.clickOnBuyNowButton(driver);

	}

	public static void addToCartWithoutLogin(WebDriver driver) {

		Wait.defaultMediumWait(driver);
		if (read.getPropertyValue("prodenv").equalsIgnoreCase("N")) {
			System.out.println("Stagging environment");
			driver.get("http://dev6.craftsvilla.com/activate");
			Wait.defaultMediumWait(driver);
			driver.findElement(By.id("dev8")).click();
			Wait.defaultMediumWait(driver);
			driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/2543448/");
			Wait.defaultHighWait(driver);

		} else {
			driver.get(read.getPropertyValue("url") + "/catalog/product/view/id/4331545/s/self-red");
		}
		/*HomePage.clic	kOnFistCategory(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.checkOnlyCODProduct(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnFirstProduct(driver);*/
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickOnBuyNowButton(driver);
		/*String cartMessage=HomePage.getmessage(driver);
		System.out.println("Cart message"+cartMessage);*/
	}

	public static void addToCartWithoutLoginAddtocartbutton(WebDriver driver) {
		driver.get(read.getPropertyValue("url") + "catalog/product/view/id/4331545/s/self-red");
		Wait.defaultHighWait(driver);
		DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		HomePage.clickonAddToCartButton(driver);
		Wait.defaultHighWait(driver);

	}

}

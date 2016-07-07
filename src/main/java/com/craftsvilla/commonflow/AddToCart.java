package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;


public class AddToCart {
	static LoginFlow login = new LoginFlow();
	static PropertyReader read=new PropertyReader();
	
	public static void addFirstProductToCart(WebDriver driver) {
		
		login.loginflow(driver);
		Wait.defaultHighWait(driver);
		driver.get(read.getPropertyValue("url")+"catalog/product/view/id/43118/s/glitter-red-bag");
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
		driver.get(read.getPropertyValue("url")+"catalog/product/view/id/3828220/s/sutra-decor-glass-metal-votive-yellow");
		
		/*HomePage.clickOnFistCategory(driver);
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
	
}

package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class LoginFlow {
	public boolean loginflow(WebDriver driver) {

		HomePage.clickOnLoginButton(driver);
		HomePage.EnterUserNameForLogin(driver);
		HomePage.enterPasswordForLogin(driver);
		HomePage.clickONSignInButton(driver);
		Wait.defaultMediumWait(driver);
		// return false;
		return HomePage.checkIfloginIsSuccessful(driver);

	}
	public boolean loginflow(WebDriver driver,String userName,String password) {

		HomePage.clickOnLoginButton(driver);
		HomePage.EnterUserNameForLogin(driver,userName);
		HomePage.enterPasswordForLogin(driver,password);
		HomePage.clickONSignInButton(driver);
		Wait.defaultMediumWait(driver);
		// return false;
		return HomePage.checkIfloginIsSuccessful(driver);

	}

}

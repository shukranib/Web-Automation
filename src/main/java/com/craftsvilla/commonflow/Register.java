package com.craftsvilla.commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class Register {
	public static boolean registerFlow(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		
		HomePage.clickOnLoginButton(driver);
		HomePage.clickOnRegisterLink(driver);
		Wait.defaultMediumWait(driver);
		HomePage.eneterFirstName(driver);
		HomePage.enterLastName(driver);
		Wait.defaultMediumWait(driver);
		HomePage.eneterMobileNo(driver);
		//HomePage.eneterMobileNo(driver);
		Wait.defaultMediumWait(driver);
		HomePage.enetrEmailIdForregister(driver);
		HomePage.eneterPasswordForRegister(driver);
		Wait.defaultMediumWait(driver);
		HomePage.eneterConfirmPassWord(driver);
		HomePage.clickOnRegisterButton(driver);
		Wait.defaultMediumWait(driver);
		return HomePage.checkIfRegisterPopupIsDisplay(driver);
	}

	public static boolean checkValidationRegisterFlow(WebDriver driver) {
		boolean result;
		HomePage.clickOnLoginButton(driver);
		HomePage.clickOnRegisterLink(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clearFirstName(driver);
		HomePage.clearLastName(driver);
		HomePage.clearMobileNo(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clearEmailIdForregister(driver);
		HomePage.clearPasswordForRegister(driver);
		Wait.defaultMediumWait(driver);
		HomePage.clickOnRegisterButton(driver);
		result = HomePage.getValidationMessageForLogin(driver);
		return result;
	}
}

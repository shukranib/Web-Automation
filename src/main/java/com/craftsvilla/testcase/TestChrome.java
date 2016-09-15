package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.commonflow.LoginFlow;
import com.craftsvilla.framework.DriverSelector;

public class TestChrome {
	public static void main(String[] args) {
		
	

			WebDriver driver=DriverSelector.getDriver();
			LoginFlow login = new LoginFlow();
			boolean result = login.loginflow(driver);
}
}
package com.craftsvilla.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;

public class ForgotPassWordTest {
	static WebDriver driver;
	static String message;

	/*
	 * @BeforeSuite() public void set() { List<String> testname = new
	 * ArrayList<>(); testname.add("testforgotPassWord"); TestNG t =
	 * Class.forName(className) t.setTestNames(testname);
	 * 
	 * }
	 */

	@Test(testName = "testforgotPassWordTest")
	public void testforgotPassWord() {

		driver = DriverSelector.getDriver();
		HomePage.clickOnLoginButton(driver);
		Wait.defaultMediumWait(driver);
		/*
		 * HomePage.clickOnForgotPassWordButton(driver);
		 * Wait.defaultMediumWait(driver);
		 * HomePage.enterEmailInForgotPassword(driver);
		 * HomePage.clickOnsubmitForgotPasswordButton(driver); message =
		 * HomePage.getValidationMessageForForgotPassword(driver);
		 * System.out.println(message);
		 * System.out.println(TestData.getSuccessMessage_fogotPassword()); //
		 * if(message.equals(TestData.G))
		 */ }

	@Test()
	public void forgotPassWordEmailValidationTest() {

		driver = DriverSelector.getDriver();
		HomePage.clickOnLoginButton(driver);
		HomePage.clickOnForgotPassWordButton(driver);
		Wait.defaultMediumWait(driver);
		HomePage.enterEmailInForgotPassword(driver, "gdshgd@gmail.com");
		HomePage.clickOnsubmitForgotPasswordButton(driver);

	}

	@AfterMethod

	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == 2) {
			Wait.defaultHighWait(driver);
			Screenshot.takeScreenshot(driver, result.getName());

		}
		driver.quit();

	}
}

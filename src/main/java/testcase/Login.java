package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;

import commonflow.LoginFlow;
import commonflow.Register;
import pageObjects.HomePage;

public class Login {

	WebDriver driver;

	@Test()
	public void startup() {

	}

	@Test()
	public void loginTest() {
		// driverselector = new DriverSelector();

		Boolean result;

		driver = DriverSelector.getDriver();
		LoginFlow login = new LoginFlow();
		result = login.loginflow(driver);
		Screenshot.takeScreenshot(driver);
		Assert.assertTrue(!result);
	}

	@Test()
	public void RegisterTest() {
		Boolean result;
		driver = DriverSelector.getDriver();

		result = Register.registerFlow(driver);
		Screenshot.takeScreenshot(driver);
		Wait.defaultMediumWait(driver);
		Assert.assertTrue(!result);

	}

	@Test()
	public void keepUserNameAndPasswordBlankTest() {
		Boolean result;
		driver = DriverSelector.getDriver();
		HomePage.clickOnLoginButton(driver);
		HomePage.clearPassWordNameTextBox(driver);
		HomePage.clearUserNameTextBox(driver);
		HomePage.clickONSignInButton(driver);
		Screenshot.takeScreenshot(driver);
		result = HomePage.getValidationMessageForLogin(driver);

		Assert.assertTrue(result);

	}

	@Test()
	public void keepPasswordBlankTest() {
		Boolean result;
		driver = DriverSelector.getDriver();
		HomePage.clickOnLoginButton(driver);
		HomePage.clearPassWordNameTextBox(driver);
		HomePage.EnterUserNameForLogin(driver);
		HomePage.clickONSignInButton(driver);
		Screenshot.takeScreenshot(driver);
		result = HomePage.getValidationMessageForLogin(driver);
		Assert.assertTrue(result);

	}

	@Test()
	public void checkValidationMessageForRegisterTest() {
		Boolean result;
		driver = DriverSelector.getDriver();
		result = Register.checkValidationRegisterFlow(driver);
		Screenshot.takeScreenshot(driver);
		Assert.assertTrue(result);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}

}

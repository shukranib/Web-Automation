package commonflow;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.Wait;

import pageObjects.HomePage;

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

}

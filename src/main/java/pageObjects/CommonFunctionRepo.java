package pageObjects;

import org.openqa.selenium.WebDriver;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;

public class CommonFunctionRepo {
	public static void clickOnCategory(WebDriver driver, String linkText) {
		DriverActions.clickByLinkText(driver, linkText);

	}

	public static void enterBillingAddress(WebDriver driver) {
		HomePage.enterFirstName_BillingInfo(driver);
		HomePage.enterLastName_BillingInfo(driver);
		HomePage.enterstreet1_BillingInfo(driver);
		HomePage.enterstreet2_BilligInfo(driver);
		HomePage.entercity_BillingInfo(driver);
		HomePage.enterpostcode_BillingInfo(driver);
		HomePage.entercountry_BillingInfo(driver);
		Wait.defaultMediumWait(driver);
		HomePage.enterregoin_BillingInfo(driver);
		HomePage.entertelephone_BillingInfo(driver);

	}
}

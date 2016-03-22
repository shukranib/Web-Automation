package com.craftsvilla.pageObjects;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Screenshot;
import com.craftsvilla.framework.Wait;

//Actions performed on Home page
public class HomePage {

	// this will open login popup
	public static void clickOnLoginButton(WebDriver driver) {
		System.out.println("Clicking on login");
		Wait.defaultMediumWait(driver);
		driver.findElement(By.xpath(".//*[@class='user-icon']")).click();
		// Screenshot.takeScreenshot(driver, "After Login");
		// DriverActions.click(driver, ObjectRepository_HomePage.button_Login);
	}

	public static void clickONSignInButton(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_signIn);
	}

	public static void clearUserNameTextBox(WebDriver driver) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_emailId);
	}

	public static void enterPasswordForLogin(WebDriver driver) {
		System.out.println("User NAme"+TestData.passWordLogin);
		Wait.defaultMediumWait(driver);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_password, TestData.passWordLogin);
	}

	public static void EnterUserNameForLogin(WebDriver driver) {
		System.out.println("User NAme"+TestData.userNameLogin);
		// driver.findElement(By.id(ObjectRepository_HomePage.textBox_emailId)).sendKeys("shukrani.bille@craftsvilla.com");
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_emailId, TestData.userNameLogin);
	}

	public static void clickOnFirstProduct(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.FirstProductFromCategory);
	}

	public static boolean checkIfRegisterPopupIsDisplay(WebDriver driver) {
		
		return DriverActions.isElementDisplay(driver, ObjectRepository_HomePage.popUp_login);

	}

	public static void clickOnRegisterLink(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.link_Register);
	}

	public static void clickOnRegisterButton(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_register);
	}

	public static void clearFirstName(WebDriver driver) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_firstName);

	}

	public static void eneterFirstName(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_firstName, TestData.firstName);

	}

	public static void clearLastName(WebDriver driver) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_lastName);
	}

	public static void enterLastName(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_lastName, TestData.lastName);
	}

	public static void clearMobileNo(WebDriver driver) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_MobileNo);
	}

	public static void eneterMobileNo(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_MobileNo, TestData.mobileNo);
	}

	public static void clearPasswordForRegister(WebDriver driver) {

		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_passwordRegister);
	}

	public static void eneterPasswordForRegister(WebDriver driver) {

		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_passwordRegister, TestData.passWordRegister);
	}

	public static void eneterConfirmPassWord(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_confirmPassWord,
				TestData.passWordConfirmRegister);
	}

	public static void clearEmailIdForregister(WebDriver driver) {
		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_emailIdRegister);
	}

	public static void enetrEmailIdForregister(WebDriver driver) {
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.textBox_emailIdRegister);
		String userEmail = TestData.emailIdRegister + new Date().getTime() + "@gmail.com";
		Log4jLogger.writeErrorLog("New register Email" + userEmail);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_emailIdRegister, userEmail);
	}

	public static void closeLoginPopup(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_CloseLoginPoup);

	}

	public static void clickOnFistCategory(WebDriver driver) {
		DriverActions.clickByLinkText(driver, TestData.ProductCategorysarees);

	}

	public static void clickOnBuyNowButton(WebDriver driver) {
		driver.findElement(By.id("buynow")).sendKeys(Keys.ENTER);

	}

	public static boolean checkIfloginIsSuccessful(WebDriver driver) {
		try {
			if (DriverActions.getText(driver, ObjectRepository_HomePage.span_loginMessage).trim()
					.equals(ObjectRepository_HomePage.text_loginMessage)) {

				Log4jLogger.writeErrorLog("Login message -"
						+ DriverActions.getText(driver, ObjectRepository_HomePage.span_loginMessage).trim());
				return true;

			}
		} catch (NoSuchElementException Ignore) {
			return false;
		}

		return false;

	}

	public static void clickOnProceedToPaymentButton(WebDriver driver) {
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_proceedToPayment);
		DriverActions.click(driver, ObjectRepository_HomePage.button_proceedToPayment);
	}

	public static void checkOnlyCODProduct(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.checkBox_OnlyCODProducts);
	}

	public static void clickOnContinueButton(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_continueOnCheckoutPage);
	}

	public static void redirecttoHomePage(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_homePageLogo);
	}

	public static void clickOnCODPaymentMethod(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_paymentCOD);

	}

	public static void clickOnPlaceOrder(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_placeOrder);
	}

	public static void clearPassWordNameTextBox(WebDriver driver) {

		DriverActions.clear(driver, ObjectRepository_HomePage.textBox_password);
	}

	public static boolean getValidationMessageForLogin(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> validationMessageList = DriverActions.findElements(driver,
				ObjectRepository_HomePage.span_loginErrorMessage);

		if (validationMessageList != null) {
			int size = validationMessageList.size();

			if (size >= 1) {
				Log4jLogger.writeErrorLog("Validation message for/register");
				for (int i = 0; i < size; i++) {
					Log4jLogger.writeErrorLog(validationMessageList.get(i).getText());

				}
				return true;
			}
		}
		return false;

	}

	public static void clickOnForgotPassWordButton(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.click(driver, ObjectRepository_HomePage.link_forgotPassWord);

	}

	public static void enterEmailInForgotPassword(WebDriver driver) {
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_forgotPassword,
				TestData.forgotPassword_emailID);
	}

	public static void clickOnsubmitForgotPasswordButton(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_submitForgotPassword);
	}

	public static void enterEmailInForgotPassword(WebDriver driver, String emailID) {
		// TODO Auto-generated method stub
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.textBox_forgotPassword, emailID);

	}

	public static String getValidationMessageForForgotPassword(WebDriver driver) {
		// TODO Auto-generated method stub
		String message = DriverActions.getText(driver, ObjectRepository_HomePage.span_Message);
		return message;
	}

	public static void enterTextToSearch(WebDriver driver) {
		String searchtext = TestData.button_searchText;

		DriverActions.sendKeys(driver, ObjectRepository_HomePage.button_searchText, searchtext);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.button_searchText, Keys.ENTER);

	}

	public static void enterTextToSearch(WebDriver driver, String searchtext) {

		DriverActions.sendKeys(driver, ObjectRepository_HomePage.button_searchText, searchtext);
		DriverActions.sendKeys(driver, ObjectRepository_HomePage.button_searchText, Keys.ENTER);

	}

	public static void clickOnWishButton(WebDriver driver) {
		
		Wait.defaultHighWait(driver);
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.Button_addToWishList);
		// Screenshot.takeScreenshot(driver, "Clicking on WishlistButton");
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.Button_addToWishList);

	}

	public static void clickOnAccount(WebDriver driver) {
		DriverActions.clickByLinkText(driver, "Account");
	}

	public static void clickOnManageAccount(WebDriver driver) {

		DriverActions.clickByLinkText(driver, "Manage Account");
	}

	public static void clickOnWishListFromManageAccount(WebDriver driver) {

		Wait.defaultMediumWait(driver);
		DriverActions.clickByLinkText(driver, "My Wishlist");
	}

	public static String getmessage(WebDriver driver) {
		return DriverActions.getText(driver, ObjectRepository_HomePage.span_Message);
	}

	public static void clickOnAllCategoryFromHomepage(WebDriver driver) {
		List<WebElement> categoryList = DriverActions.findElements(driver,
				ObjectRepository_HomePage.link_allCategoryfromHomepage);
		int size = categoryList.size();
		int halfsize = categoryList.size() / 2;

		for (int i = 0; i < size; i++) {
			categoryList = DriverActions.findElements(driver, ObjectRepository_HomePage.link_allCategoryfromHomepage);
			if (halfsize < i) {
				DriverActions.scrollDownWindow(driver);
			}
			Log4jLogger.writeErrorLog(categoryList.get(i).getText());

			categoryList.get(i).click();
			Wait.defaultHighWait(driver);
			Wait.defaultHighWait(driver);
			Log4jLogger.writeErrorLog(DriverActions.getText(driver, ObjectRepository_HomePage.Span_lastPageNo));
			Log4jLogger.writeErrorLog("Pages");
			Screenshot.takeScreenshot(driver);
			redirecttoHomePage(driver);
			Wait.defaultHighWait(driver);

		}
	}

	public static void openFirstProductFromWishList(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.FirstProductFromWishlist);
		// Screenshot.takeScreenshot(driver, "AfterclickngOn product");
	}

	public static void clickOnViewMoreButtonForSubcategory(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.button_viewMore);
	}

	public static void clickOnAllFeedPages(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> feedPagesList = DriverActions.findElements(driver,
				ObjectRepository_HomePage.feedPagesOnHomePage);
		int size = feedPagesList.size();

		for (int i = 0; i < size; i++) {

			feedPagesList = DriverActions.findElements(driver, ObjectRepository_HomePage.feedPagesOnHomePage);
			if (i <= 9) {
				DriverActions.scrollDownWindow(driver);
			}
			if (i > 9) {
				DriverActions.scrollDownhalfWindow(driver);
			}

			Log4jLogger.writeErrorLog(feedPagesList.get(i).getText());

			feedPagesList.get(i).click();
			Wait.defaultHighWait(driver);
			Wait.defaultHighWait(driver);

			Log4jLogger.writeErrorLog("Pages");
			Log4jLogger.writeErrorLog(driver.getCurrentUrl());
			// Screenshot.takeScreenshot(driver);
			redirecttoHomePage(driver);
			Wait.defaultHighWait(driver);
		}
	}

	public static String getCurrentpageURL(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public static void clickOnSubCategory(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Kanchivaram Sarees")).click();
		// DriverActions.click(driver,ObjectRepository_HomePage.link_subcategory);
	}
}

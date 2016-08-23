package com.craftsvilla.testcase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileTest {

	//WebDriver driver;

	AndroidDriver<MobileElement> driver = null;

	//AndroidDriver
	@Test(enabled = false)
	public void appAutomationtesting() {

		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("deviceName", "65a2b779");
		cap.setPlatform(Platform.ANDROID);
		//cap.setCapability("app", new File("/home/shukrani/appium-demo/data/app.apk").getAbsolutePath());
		cap.setCapability("appPackage", "com.craftsvilla.app");
		cap.setCapability("unicodekeyboard", true);
		cap.setCapability("appActivity", "com.craftsvilla.app.controller.SplashActivity");
		cap.setCapability("platformName", "Android");
		try {
			/*com.craftsvilla.app:id/textviewFilter 
			com.craftsvilla.app:id/tvFilterNameMain text=COD
					com.craftsvilla.a`pp:id/checkboxSubCategory//checkbox
					com.craftsvilla.app:id/filtersApplyButton//apply button*/
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("com.craftsvilla.app:id/action_settings")).click();
			Wait.defaultMediumWait(driver);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
			driver.getKeyboard();
			driver.findElement(By.id("com.craftsvilla.app:id/edittextEmail"))
					.sendKeys("vishal.bhongare@craftsvilla.com");
			Wait.defaultMediumWait(driver);
			//if (checkStatusOfKeyboard()) {

			//}

			Wait.defaultMediumWait(driver);
			//driver.getKeyboard();
			driver.findElement(By.id("com.craftsvilla.app:id/edittextPwd")).sendKeys("vishal09");
			//if (checkStatusOfKeyboard()) {
			//driver.hideKeyboard();
			//}
			driver.findElement(By.id("com.craftsvilla.app:id/btnLogin")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.className("android.widget.ImageButton")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/textView")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/textviewFilter")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.xpath("//android.widget.TextView[@text='COD']")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/checkboxSubCategory")).click();
			Wait.defaultsmallWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/filtersApplyButton")).click();
			Wait.defaultHighWait(driver);

			driver.findElement(By.id("com.craftsvilla.app:id/itemImageView")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/buyNowButton")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/proceedToPaymentButton")).click();
			Wait.defaultHighWait(driver);

			driver.findElement(By.id("com.craftsvilla.app:id/relativeLayout")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/proceedToPaymentAddressButton")).click();
			//addres
			Wait.defaultHighWait(driver);
			driver.findElement(By.className("android.widget.Button")).click();
			Wait.defaultHighWait(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test()
	public void appAutomationtesting_guestCheckout() {
		MobileElement currentelement;
		String userEmail = "TestCraftsvilla" + new Date().getTime() + "@testvilla.com";
		Log4jLogger.writeErrorLog("New register Email" + userEmail);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "65a2b779");
		cap.setPlatform(Platform.ANDROID);
		cap.setCapability("app", new File("/home/shukrani/appium-demo/data/apk.apk").getAbsolutePath());
		cap.setCapability("appPackage", "com.craftsvilla.app");
		cap.setCapability("unicodekeyboard", true);
		cap.setCapability("appActivity", "com.craftsvilla.app.controller.SplashActivity");
		cap.setCapability("platformName", "Android");
		try {
			/*com.craftsvilla.app:id/textviewFilter 
			com.craftsvilla.app:id/tvFilterNameMain text=COD
					com.craftsvilla.app:id/checkboxSubCategory//checkbox
					com.craftsvilla.app:id/filtersApplyButton//apply button*/
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Wait.defaultHighWait(driver);

			currentelement = driver.findElement(By.className("android111.widget.ImageButton"));
			currentelement.isDisplayed();
			Assert.assertTrue(currentelement.isDisplayed());
			currentelement.click();

			Wait.defaultHighWait(driver);
			currentelement = driver.findElement(By.id("com.craftsvilla.app:id/textView"));
			Assert.assertEquals(currentelement.isDisplayed(), true);
			currentelement.click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/textviewFilter")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.xpath("//android.widget.TextView[@text='COD']")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/checkboxSubCategory")).click();
			Wait.defaultsmallWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/filtersApplyButton")).click();
			Wait.defaultHighWait(driver);

			driver.findElement(By.id("com.craftsvilla.app:id/itemImageView")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/buyNowButton")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/proceedToPaymentButton")).click();
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/btnContinueAsGuest")).click();
			Wait.defaultMediumWait(driver);
			System.out.println("Guest User Email Is" + userEmail);
			driver.findElement(By.id("com.craftsvilla.app:id/continueAsGuestEmailAddress")).sendKeys(userEmail);
			Wait.defaultMediumWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/continue_button")).click();
			Wait.defaultHighWait(driver);
			enterbillingAddress(driver);
			Wait.defaultHighWait(driver);
			driver.findElement(By.id("com.craftsvilla.app:id/relativeLayout")).click();
			Wait.defaultHighWait(driver);

			driver.findElement(By.id("com.craftsvilla.app:id/proceedToPaymentAddressButton")).click();
			//addres
			Wait.defaultHighWait(driver);
			driver.findElement(By.className("android.widget.Button")).click();
			Wait.defaultHighWait(driver);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	private void enterbillingAddress(AndroidDriver driver) {
		try {
			driver.findElement(By.id("com.craftsvilla.app:id/editTextFirstName")).sendKeys("TestOrder");
			driver.findElement(By.id("com.craftsvilla.app:id/editTextLastName")).sendKeys("TestOrder");
			driver.findElement(By.id("com.craftsvilla.app:id/editTextFullAddress")).sendKeys("This is test order");
			driver.hideKeyboard();
			driver.findElement(By.id("com.craftsvilla.app:id/editTextPincode")).sendKeys("400069");
			driver.hideKeyboard();
			driver.findElement(By.id("com.craftsvilla.app:id/editTextMobileNumber")).sendKeys("1234567895");
			driver.findElement(By.id("com.craftsvilla.app:id/proceedPayment")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}

package com.craftsvilla.testcase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.DriverSelector;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.AddToCartPage;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class OutOfStockScript {
	WebDriver driver;
	static PropertyReader configReader = new PropertyReader();

	@Test
	public void outofstockScript() {
		try {
			driver = DriverSelector.getDriver_browserstacknew();
			Wait.defaultHighWait(driver);

			List<WebElement> categoryList = DriverActions.findElements(driver,
					ObjectRepository_HomePage.allsubcategory);
			List<WebElement> productlist;
			int size = categoryList.size();

			for (int i = 2; i < size; i++) {
				categoryList = DriverActions.findElements(driver, ObjectRepository_HomePage.allsubcategory);
				System.out.println(categoryList.get(i).getText());
				String allmemulink = categoryList.get(i).getAttribute("href");
				System.out.println("URL is " + allmemulink);
				driver.get(allmemulink);
				Wait.defaultHighWait(driver);
				Wait.defaultHighWait(driver);
				productlist = DriverActions.findElements(driver, ObjectRepository_HomePage.allproductimage);
				for (int j = 0; j < productlist.size(); j++) {
					productlist.get(i).click();
					Wait.defaultHighWait(driver);
					Wait.defaultHighWait(driver);
					HomePage.clickonAddToCartButton(driver);
					Wait.defaultHighWait(driver);
					Wait.defaultHighWait(driver);
					int no = AddToCartPage.getNoofProductInCart(driver);
					System.out.println("No of product" + no);
					driver.get(allmemulink);

				}
				driver.quit();
				Wait.defaultHighWait(driver);
				driver = DriverSelector.getDriver_browserstacknew();

				/*categoryList.get(i).click();
				Wait.defaultHighWait(driver);
				Wait.defaultHighWait(driver);
				Log4jLogger.writeErrorLog(DriverActions.getText(driver, ObjectRepository_HomePage.Span_lastPageNo));
				Log4jLogger.writeErrorLog("Pages");
				Screenshot.takeScreenshot(driver);
				redirecttoHomePage(driver);
				Wait.defaultHighWait(driver);*/
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		} finally {
			driver.quit();
		}
	}
}

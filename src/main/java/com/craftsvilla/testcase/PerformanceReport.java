package com.craftsvilla.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class PerformanceReport {
	WebDriver driver;
	long endtime;
	long starttime;
	long totaltime;
	static FileWriter writer;

	@Test
	public void loadingTimeForCategoryPage() {
		File csvfile = new File("/home/shukrani/test.csv");

		try {
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append("\n");

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			starttime = System.currentTimeMillis();
			driver.get("http://www.craftsvilla.com/");
			endtime = System.currentTimeMillis();
			writer.append("Total time required for homepage");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
			HomePage.enterTextToSearch(driver);
			starttime = System.currentTimeMillis();
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.FirstProductFromSearch);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for Search");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
			HomePage.redirecttoHomePage(driver);
			Wait.defaultHighWait(driver);

			HomePage.clickOnFistCategory(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.FirstProductFromCategory);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for Category Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
			HomePage.clickOnSubCategory(driver);

			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.FirstProductFromCategory);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for Subcategory Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

			HomePage.checkOnlyCODProduct(driver);
			Wait.defaultHighWait(driver);

			HomePage.clickOnFirstProduct(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_buyNow);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for product Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
			//Wait.defaultHighWait(driver);

			HomePage.clickOnBuyNowButton(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.product_nameOnOrdeSummaryPage);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for cart Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append("\n");
			reset();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();

			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public long calculatetimeinsec(long starttime, long endtime) {

		totaltime = ((endtime - starttime) / 1000);
		return totaltime;

	}

	public void reset() {
		starttime = 0;
		endtime = 0;
		totaltime = 0;
	}
}
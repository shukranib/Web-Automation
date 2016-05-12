package com.craftsvilla.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.PropertyReader;
import com.craftsvilla.framework.Wait;
import com.craftsvilla.pageObjects.HomePage;
import com.craftsvilla.pageObjects.ObjectRepository_HomePage;

public class PerformanceReport {
	static WebDriver driver;
	long endtime;
	long starttime;
	long totaltime;
	static FileWriter writer;
	
	@Test
	public void loadingTimeForCategoryPage() {
		 
		 PropertyReader read=new PropertyReader();
		File csvfile = new File("src/main/resources/Input/PerformanceReport.csv");
			if(!csvfile.exists())
			{
				try {
					csvfile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("FILE is created");
			}
		try {
			Date date=new Date();
			String datestring=date.toString();
			writer = new FileWriter(csvfile, true);
			writer.append("Page Name");
			writer.append(";");
			writer.append("Page loading time(in sec)");
			writer.append(";");
			writer.append("Date and time");
			writer.append("\n");

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			starttime = System.currentTimeMillis();
			driver.get("http://www.craftsvilla.com/");
			endtime = System.currentTimeMillis();
			writer.append("Total time required for homepage");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
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
			writer.append(";");
			writer.append(datestring);
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
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();

			Wait.defaultHighWait(driver);
			HomePage.clickOnSubCategory(driver);

			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.FirstProductFromSubCategory);
			endtime = System.currentTimeMillis();
			writer.append("Time taken to requuired subcategory page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			
			reset();
			driver.get(read.getPropertyValue("url")+"catalog/product/view/id/4331545/s/test");
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_buyNow);
			endtime = System.currentTimeMillis();
			writer.append("Time to load product page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			
			Wait.defaultsmallWait(driver);
			HomePage.clickOnBuyNowButton(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("BUY now button");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.product_nameOnOrdeSummaryPage);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for cart Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			writer.append("\n");
			reset();
			
			Wait.defaultsmallWait(driver);
			HomePage.clickOnProceedToPaymentButton(driver);
			starttime = System.currentTimeMillis();
			System.out.println("Start time is" + starttime);
			System.out.println("checkout");
			DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.button_continueAsGuest);
			endtime = System.currentTimeMillis();
			writer.append("Total time required for checkout Page");
			writer.append(";");
			writer.append(String.valueOf(calculatetimeinsec(starttime, endtime)));
			writer.append(";");
			writer.append(datestring);
			
			writer.append("\n");
			reset();
					
			//Wait.defaultHighWait(driver);

			
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
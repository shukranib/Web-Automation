package com.craftsvilla.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void takeScreenshot(WebDriver driver) {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		PropertyReader propertyReader = new PropertyReader();
		try {

			String newFileName = propertyReader.getPropertyValue("sreenshotdirectory")
					+ propertyReader.getPropertyValue("screenshotname")
					+ new SimpleDateFormat("yyyymmddhhmm").format(new Date())+".jpg";
			FileUtils.copyFile(screenshot, new File(newFileName));
			System.out.println("Screenshot taken");
		} catch (IOException e) {

			Log4jLogger.writeErrorLog(e.getMessage());
		}
	}

	public static void takeScreenshot(WebDriver driver, String name) {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		PropertyReader propertyReader = new PropertyReader();
		try {

			String newFileName = propertyReader.getPropertyValue("sreenshotdirectory") + name
					+ new SimpleDateFormat("yyyymmddhhmm").format(new Date())+".jpg";
			FileUtils.copyFile(screenshot, new File(newFileName));
		} catch (IOException e) {

			Log4jLogger.writeErrorLog(e.getMessage());
		}
	}
}

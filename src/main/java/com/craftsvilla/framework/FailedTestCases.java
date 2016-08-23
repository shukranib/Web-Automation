package com.craftsvilla.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class FailedTestCases {

	static File urlForFailedTestcases = new File("test-output/FailedTestcasesUrl.txt");
	static FileOutputStream output;
	static BufferedWriter bufferedWriter;
	static FileWriter fileWriter;
	static File screenshotfile = new File("test-output/");

	public static void actionAfterFailedTestcase(WebDriver driver, ITestResult result) { // TODO
		System.out.println("URL for" + result.getName() + "\tis\t" + driver.getCurrentUrl() + "\n");
		Wait.defaultHighWait(driver);
		Screenshot.takeScreenshot(driver, result.getName());
		Wait.defaultMediumWait(driver);
		if (!urlForFailedTestcases.exists()) {
			try {
				urlForFailedTestcases.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fileWriter = new FileWriter(urlForFailedTestcases, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("URL for " + result.getName() + "\tis\t" + driver.getCurrentUrl() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// fileWriter.close();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void codecleanup() {
		if (urlForFailedTestcases.exists()) {
			urlForFailedTestcases.delete();
		}
		File[] listfile = screenshotfile.listFiles();
		for (int i = 0; i < listfile.length; i++) {
			//System.out.println("deleting" + listfile[i].getName());
			listfile[i].delete();
		}

	}
}

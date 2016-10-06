package com.craftsvilla.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	static WebDriverWait wait;

	public static void defaultMediumWait(WebDriver driver) {

		synchronized (driver) {
			try {
				driver.wait(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void defaultHighWait(WebDriver driver) {
		synchronized (driver) {
			try {
				driver.wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void defaultsmallWait(WebDriver driver) {
		synchronized (driver) {
			try {
				driver.wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

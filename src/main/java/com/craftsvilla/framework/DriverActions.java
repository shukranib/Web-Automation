package com.craftsvilla.framework;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.craftsvilla.exceptions.UIElementNotFound;

public class DriverActions {
	static UIElement elements = new UIElement();
	static WebDriverWait wait;
	static JavascriptExecutor jse;

	public static void click(WebDriver driver, String elementName) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		System.out.println("element name" + elementName);
		System.out.println("Locator is" + locator);

		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.xpath(locator)).click();
			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.id(locator)).click();
			}
			if (by.equals("class")) {

				Wait.defaultsmallWait(driver);
				driver.findElement(By.className(locator)).click();
			}
			if (by.equals("linktext")) {

				Wait.defaultsmallWait(driver);
				driver.findElement(By.linkText(locator)).sendKeys(Keys.ENTER);

			}
		} else {
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
	}

	public static void sendKeys(WebDriver driver, String elementName, String text) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		System.out.println("element name" + elementName);
		System.out.println("Locator is" + locator);
		if (by != null && locator != null) {

			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(text);

			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.id(locator)).click();
				driver.findElement(By.id(locator)).clear();
				driver.findElement(By.id(locator)).sendKeys(text);
			}
			if (by.equals("class")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.className(text)).clear();
				driver.findElement(By.className(locator)).sendKeys(text);
			}
		} else {
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
	}

	public static void sendKeys(WebDriver driver, String elementName, Keys keys) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.xpath(locator)).sendKeys(keys);

			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.id(locator)).click();
				driver.findElement(By.id(locator)).sendKeys(keys);
			}
			if (by.equals("class")) {
				Wait.defaultsmallWait(driver);
				driver.findElement(By.className(locator)).sendKeys(keys);
			}
		} else {
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
	}

	public static boolean isElementDisplay(WebDriver driver, String elementName) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		boolean result = false;
		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				try {

					Wait.defaultsmallWait(driver);
					result = driver.findElement(By.xpath(locator)).isDisplayed();
				} catch (NoSuchElementException ignored) {
					return false;
				}
			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				result = driver.findElement(By.id(locator)).isDisplayed();
			}
			if (by.equals("class")) {
				Wait.defaultsmallWait(driver);
				result = driver.findElement(By.className(locator)).isDisplayed();
			}
		} else

		{
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
		return result;

	}

	public static String getText(WebDriver driver, String elementName) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);

		String text = "";
		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				text = driver.findElement(By.xpath(locator)).getText();
				return text;
			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				text = driver.findElement(By.id(locator)).getText();
				return text;
			}
			if (by.equals("class")) {

				Wait.defaultsmallWait(driver);
				text = driver.findElement(By.className(locator)).getText();
				return text;
			}
		} else

		{
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
		return text;
	}

	public static void clickByLinkText(WebDriver driver, String linkText) {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText(linkText)).sendKeys(Keys.ENTER);
	}

	public static void clickOnLinkText(WebDriver driver, String linkText) {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText(linkText)).click();
	}

	public static void selectByvisibleText(WebDriver driver, String elementName, String text) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		// TODO Auto-generated method stub
		Select listBox;

		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				listBox = new Select(driver.findElement(By.xpath(locator)));
				listBox.selectByVisibleText(text);
			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				listBox = new Select(driver.findElement(By.id(locator)));
				listBox.selectByVisibleText(text);
			}
			if (by.equals("class")) {
				Wait.defaultsmallWait(driver);
				listBox = new Select(driver.findElement(By.id(locator)));
			}

		} else {
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}

	}

	public static void waitUntilElementdisplay(WebDriver driver, String elementName) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);

		wait = new WebDriverWait(driver, 600);
		if (by.equals("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
		if (by.equals("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		}
		if (by.equals("class")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		}
		if (by.equals("linktext")) {

			Wait.defaultsmallWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		}
	}

	public static void clear(WebDriver driver, String elementName) {
		// TODO Auto-generated method stub
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		if (by.equals("id")) {
			driver.findElement(By.id(locator)).click();
			driver.findElement(By.id(locator)).clear();
		}
		if (by.equals("xpath")) {
			driver.findElement(By.xpath(locator));
			driver.findElement(By.xpath(locator)).clear();
		}

	}

	public static void clickOnOkButtonForPopUp(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void mousehover(WebDriver driver, String elementName) {
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		System.out.println("element name" + elementName);
		System.out.println("Locator is" + locator);

		Actions action = new Actions(driver);

		if (by != null && locator != null) {
			if (by.equals("xpath")) {
				Wait.defaultsmallWait(driver);
				WebElement we = driver.findElement(By.xpath(elementName));
				action.moveToElement(we).build().perform();
			}
			if (by.equals("id")) {
				Wait.defaultsmallWait(driver);
				WebElement we = driver.findElement(By.id(elementName));
				action.moveToElement(we).build().perform();
			}
			if (by.equals("class")) {

				WebElement we = driver.findElement(By.className(elementName));
				action.moveToElement(we).build().perform();
			}
			if (by.equals("linktext")) {

				WebElement we = driver.findElement(By.linkText(elementName));
				action.moveToElement(we).build().perform();

			}
		} else {
			try {
				throw new UIElementNotFound("ElementName/Locator Not Found in UI element sheet" + elementName);
			} catch (UIElementNotFound e) {

				e.printStackTrace();
			}
		}
	}

	public static List<WebElement> findElements(WebDriver driver, String elementName) {
		// TODO Auto-generated method stub
		String by = elements.getbyName(elementName);
		String locator = elements.getlocatorName(elementName);
		List<WebElement> elementList = null;
		if (by.equals("id")) {

			elementList = driver.findElements(By.id(locator));
			return elementList;
		}
		if (by.equals("xpath")) {
			elementList = driver.findElements(By.xpath(locator));
			return elementList;
		}
		return elementList;
	}

	public static void scrollDownWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,260)");
	}

	public static void scrollDownWindowsmall(WebDriver driver) {
		// TODO Auto-generated method stub
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,100)");
	}

	public static void scrollDownhalfWindow(WebDriver driver) {
		System.out.println("Scrolling Down Window");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}

	public static void scrollmorethanhalfWindow(WebDriver driver) {
		System.out.println("Scrolling Down More Than half window");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)", "");
	}

	public static void scrollTopWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(250,0)");
	}

}

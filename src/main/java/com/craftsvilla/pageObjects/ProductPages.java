package com.craftsvilla.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.craftsvilla.framework.DriverActions;
import com.craftsvilla.framework.Log4jLogger;
import com.craftsvilla.framework.Wait;

public class ProductPages {
	public static void applyDiscountFilterAbove50(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilter50);
	}

	public static void applyDiscountFilterAbove40(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilterAbove40);
	}

	public static void applyDiscountFilterAbove30(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilterAbove30);
	}

	public static void applyDiscountFilterAbove20(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilterAbove20);
	}

	public static void applyDiscountFilterAbove10(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilterAbove10);
	}

	public static void clickToExpandDiscountFilter(WebDriver driver) {
		DriverActions.click(driver, ObjectRepository_HomePage.span_DiscountFilter);
	}

	public static void applypricefilter500_1000(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "500Price");
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_500_1000);
		//DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_500_1000);

	}

	public static void applypricefilter500_1000OnSearchPage(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "500Price");
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_500_1000);
		// DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_0_500SearchPage);

	}

	public static void applypricefilter1000_2000(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "1000Price");

		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);
		//DriverActions.scrollDownWindow(driver);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

	}

	public static void applypricefilter1000_2000OnsearchPage(WebDriver driver) {
		// Screenshot.takeScreenshot(driver, "1000Price");
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_1000_2000);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_1000_2000SearchPage);

	}

	public static void applypricefilter2000_5000(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_2000_5000);
		//DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_2000_5000);

	}

	public static void applypricefilter2000_5000OnsearchPage(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_2000_5000);

		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_2000_5000SearchPage);

	}

	public static void applyPriceFilterAbove5000(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_above5000);
		//DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_above5000);
	}

	public static void applyPriceFilterAbove5000OnSearchPage(WebDriver driver) {
		Wait.defaultMediumWait(driver);
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_500_1000);
		Wait.defaultHighWait(driver);

		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_above5000SearchPage);
	}

	public static boolean getPriceofproductsOncategorypage(WebDriver driver, int min, int max) {
		System.out.println("Price is");
		List<WebElement> productsprice = DriverActions.findElements(driver, ObjectRepository_HomePage.productprice);
		List<WebElement> nondiscproductsprice = DriverActions.findElements(driver,
				ObjectRepository_HomePage.nondiscountproduct_PDP);
		productsprice.addAll(nondiscproductsprice);
		System.out.println("Price is" + productsprice.size());
		List<Integer> intproductprice = new ArrayList<>();
		int price;
		for (int i = 0; i < productsprice.size(); i++) {
			String formattedvalue = productsprice.get(i).getText();
			formattedvalue = formattedvalue.trim();
			StringBuffer formattedvaluebuffer = new StringBuffer(formattedvalue);
			int detelechar = formattedvaluebuffer.indexOf("₹");

			formattedvaluebuffer.deleteCharAt(detelechar);
			if (formattedvalue.contains(",")) {
				formattedvalue = formattedvalue.trim();

				System.out.println("Price is" + formattedvalue);
				int pos = formattedvaluebuffer.indexOf(",");
				while (pos != -1) {
					formattedvaluebuffer.deleteCharAt(pos);
					pos = formattedvaluebuffer.indexOf(",");

				}

				price = Integer.parseInt(formattedvaluebuffer.toString().trim());
				System.out.println("price is" + price);
				intproductprice.add(price);
			} else {
				price = Integer.parseInt(formattedvaluebuffer.toString().trim());
				System.out.println("Price is" + price);
				intproductprice.add(price);
			}
		}
		for (int i = 0; i < intproductprice.size(); i++) {
			if (min == 5000) {
				if (intproductprice.get(i) < min) {
					Log4jLogger.writeErrorLog("Invalid price product" + intproductprice.get(i));
					Log4jLogger.writeErrorLog("Price filter Not Working for above" + min);
					return false;
				}
			} else {
				if (intproductprice.get(i) < min || intproductprice.get(i) > max) {
					Log4jLogger.writeErrorLog("Invalid price product" + intproductprice.get(i));
					Log4jLogger.writeErrorLog("Price filter Not Working for" + min + "To" + max);
					return false;
				}
			}
		}
		return true;

	}

	public static void applypricefilter0_500(WebDriver driver) {
		// TODO Auto-generated method stub
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_0_500);
		Wait.defaultHighWait(driver);
		//DriverActions.scrollDownWindow(driver);
		Wait.defaultHighWait(driver);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_0_500);
	}

	public static void applypricefilter0_500OnSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		//DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.PriceFilter_0_500);
		Wait.defaultHighWait(driver);
		DriverActions.click(driver, ObjectRepository_HomePage.PriceFilter_0_500SearchPage);
	}

	public static boolean getPriceofproductsOncategorypage(WebDriver driver, String sort) {
		// TODO Auto-generated method stub
		List<WebElement> productsprice = DriverActions.findElements(driver, ObjectRepository_HomePage.productprice);
		List<Integer> intproductprice = new ArrayList<>();
		List<Integer> sortedPrice = new ArrayList<>();
		Boolean result = true;
		int price;
		for (int i = 0; i < productsprice.size(); i++) {
			String formattedvalue = productsprice.get(i).getText();
			if (formattedvalue.contains(",")) {
				StringBuffer formattedvaluebuffer = new StringBuffer(formattedvalue);
				int pos = formattedvaluebuffer.indexOf(",");
				while (pos != -1) {
					formattedvaluebuffer.deleteCharAt(pos);
					pos = formattedvaluebuffer.indexOf(",");

				}
				int detelechar = formattedvaluebuffer.indexOf("₹");

				formattedvaluebuffer.deleteCharAt(detelechar);

				price = Integer.parseInt(formattedvaluebuffer.toString().trim());
				intproductprice.add(price);
				//price = Integer.parseInt(formattedvaluebuffer.toString());
				//intproductprice.add(price);
			} else {
				price = Integer.parseInt(formattedvalue);
				intproductprice.add(price);
			}

		}
		sortedPrice.addAll(intproductprice);
		if (sort.equalsIgnoreCase("ASC")) {
			System.out.println("ASC sorting");
			Collections.sort(sortedPrice);
		} else {
			Collections.sort(sortedPrice, Collections.reverseOrder());
		}
		for (int i = 0; i < intproductprice.size(); i++) {
			if (!intproductprice.get(i).equals(sortedPrice.get(i))) {
				System.out.println("Price Sorting mismatch" + sortedPrice.get(i));
				result = false;
			}
		}

		return result;
	}

	public static void clickOnPriceSorting(WebDriver driver, String sort) {
		DriverActions.waitUntilElementdisplay(driver, ObjectRepository_HomePage.ListBox_sortOrder);
		if (sort.equalsIgnoreCase("ASC")) {
			DriverActions.selectByvisibleText(driver, ObjectRepository_HomePage.ListBox_sortOrder,
					"Price: Low to High");
		} else {
			DriverActions.selectByvisibleText(driver, ObjectRepository_HomePage.ListBox_sortOrder,
					"Price: High to Low");
		}
	}

	public static void clickOnPriceSortingOnCategoryPage(WebDriver driver, String sort) {
		Wait.defaultHighWait(driver);
		if (sort.equalsIgnoreCase("ASC")) {
			DriverActions.click(driver, ObjectRepository_HomePage.priceAsc_SortCategory);
		} else {
			DriverActions.click(driver, ObjectRepository_HomePage.priceDsc_SortCategory);
		}
	}

	public static Boolean getDiscountofproductsOncategorypage(WebDriver driver, int min) {
		List<WebElement> discountList = DriverActions.findElements(driver,
				ObjectRepository_HomePage.span_DiscountSaveOnProduct);
		int price;
		boolean result = true;
		for (int i = 0; i < discountList.size(); i++) {
			String discount = discountList.get(i).getText().trim();
			discount = discount.replace("Save", "  ");
			discount = discount.replace("%", "  ").trim();
			price = Integer.parseInt(discount);
			if (price < min) {
				System.out.println("Wrong discount is" + price);
				result = false;
				return result;
			}
		}
		return result;
	}

}

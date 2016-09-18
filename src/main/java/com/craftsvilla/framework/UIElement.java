package com.craftsvilla.framework;

import java.util.List;

import com.craftsvilla.dataobjects.UIElementsBo;

public class UIElement {
	public static List<UIElementsBo> list;

	// public static ExclFileRead test;
	public UIElement() {
		list = ExclFileRead.exclFileRead();
	}

	public String getlocatorName(String elementName) {
		String locator = "";
		for (UIElementsBo iterator : list) {

			if (iterator.getElemetName().trim().equalsIgnoreCase(elementName.trim())) {

				locator = iterator.getLocator();
				return locator;
			}

		}
		return locator;
	}

	public String getbyName(String elementName) {
		String locator = "";
		for (UIElementsBo iterator : list) {

			if (iterator.getElemetName().equals(elementName)) {

				locator = iterator.getBy();
				// return locator;
			}

		}

		return locator;

	}

}

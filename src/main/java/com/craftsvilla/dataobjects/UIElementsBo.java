package com.craftsvilla.dataobjects;

public class UIElementsBo {
	String elemetName;
	String by;
	String locator;

	public String getElemetName() {
		return elemetName;
	}

	public void setElemetName(String elemetName) {
		this.elemetName = elemetName;
	}

	public String getBy() {
		return by;
	}

	@Override
	public String toString() {
		return "UIBO [elemetName=" + elemetName + ", by=" + by + ", locator=" + locator + "]";
	}

	public UIElementsBo(String elemetName, String by, String locator) {
		super();
		this.elemetName = elemetName;
		this.by = by;
		this.locator = locator;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}
}

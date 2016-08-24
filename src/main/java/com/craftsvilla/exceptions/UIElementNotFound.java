package com.craftsvilla.exceptions;

import com.craftsvilla.framework.Log4jLogger;

public class UIElementNotFound extends Exception {
	public UIElementNotFound(String message) {
		super(message);
		Log4jLogger.writeErrorLog("ElementName/Locator Not Found in UI element sheet" + message);
	}

}

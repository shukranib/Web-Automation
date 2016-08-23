package com.craftsvilla.dataobjects;

public class EnvironmentBo {
	private static String os;

	public static String getOs() {
		return os;
	}

	public static void setOs(String os) {
		EnvironmentBo.os = os;
	}

	public static String getBrowsersName() {
		return browsersName;
	}

	public static void setBrowsersName(String browsersName) {
		EnvironmentBo.browsersName = browsersName;
	}

	public static String getBrowserversion() {
		return browserversion;
	}

	public static void setBrowserversion(String browserversion) {
		EnvironmentBo.browserversion = browserversion;
	}

	private static String browsersName;
	private static String browserversion;

}

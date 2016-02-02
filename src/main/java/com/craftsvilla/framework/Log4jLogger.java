package com.craftsvilla.framework;

import org.apache.log4j.Logger;

public class Log4jLogger {
	final static Logger logger = Logger.getLogger("TEST");

	public static void writeErrorLog(String message) {
		logger.error(message);
	}

	public static void writeDebugLogs(String message) {
		logger.debug(message);
	}

	public static void writeInfoLogs(String message) {
		logger.info(message);
	}
}

package com.craftsvilla.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	FileInputStream configfile;
	Properties configproperties;

	public PropertyReader() {
		// TODO Auto-generated constructor stub

		try {

			configfile = new FileInputStream(new File("src/main/resources/Input/Config.properties"));

			configproperties = new Properties();
			configproperties.load(configfile);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public String getPropertyValue(String propertyName) {

		return configproperties.getProperty(propertyName);

	}
}

package com.craftsvilla.framework;

import java.util.List;

import com.craftsvilla.dataobjects.TestDataBO;
import com.craftsvilla.exceptions.UIElementNotFound;

public class GetTestData {
	public static List<TestDataBO> list;

	// public static ExclFileRead test;
	public GetTestData() {

		list = ExclFileRead.readTestDataxls();
	}

	public String getTestData(String elementName) {
		String testData = "";
		for (TestDataBO iterator : list) {

			if (iterator.getFieldName().equals(elementName)) {

				testData = iterator.getTestData();
				return testData;
			}
			if (testData == null) {
				try {
					throw new UIElementNotFound("Specified fieldname/value not found in testdata sheet" + elementName);
				} catch (UIElementNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return testData;
	}

}

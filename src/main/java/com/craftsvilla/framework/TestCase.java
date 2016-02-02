package com.craftsvilla.framework;

import java.util.ArrayList;
import java.util.List;

import dataobjects.TestCaseBo;

public class TestCase {
	private static List<String> testcaselist;
	private static List<TestCaseBo> listTestCaseBo;
	private ExclFileRead exclFileRead;

	public static List<String> getTestCasesNames(String status) {
		testcaselist = new ArrayList<>();
		listTestCaseBo = ExclFileRead.readTestCasexls();
		for (TestCaseBo testcase : listTestCaseBo) {

			if (testcase.getStatus().equalsIgnoreCase(status)) {
				testcaselist.add(testcase.getTestCaseName());
			}

		}
		return testcaselist;
	}

}

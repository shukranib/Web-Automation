package com.craftsvilla.framework;

import java.util.ArrayList;
import java.util.List;

import com.craftsvilla.dataobjects.TestCaseBo;
import com.craftsvilla.dataobjects.TestCaseResult;

public class TestCase {
	private static List<String> testcaselist;
	private static List<TestCaseBo> listTestCaseBo;

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

	public static ArrayList<TestCaseResult> prepareTestCaseResult(ArrayList<TestCaseResult> testCaseResults) {
		listTestCaseBo = ExclFileRead.readTestCasexls();
		TestCaseBo caseBo;
		TestCaseResult caseResult;

		for (int j = 0; j < listTestCaseBo.size(); j++) {
			for (int i = 0; i < testCaseResults.size(); i++) {
				if ((listTestCaseBo.get(j).getTestCaseName())
						.equalsIgnoreCase((testCaseResults.get(i).getTestCaseName()))) {
					testCaseResults.get(i).setSeverity(listTestCaseBo.get(j).getSeverity());
				}
			}
		}
		return testCaseResults;
	}
}

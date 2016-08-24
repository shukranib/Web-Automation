
package com.craftsvilla.framework;

import java.util.ArrayList;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.craftsvilla.dataobjects.TestCaseResult;

public class CustomReportGenerator implements ITestListener {
	PropertyReader configReader = new PropertyReader();
	static int failCount = 0;
	static int passcount = 0;

	ArrayList<TestCaseResult> testCaseResults = new ArrayList<>();
	TestCaseResult caseResult;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Excuting  " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		passcount = passcount + 1;
		System.out.println("Passed");
		caseResult = new TestCaseResult(result.getName(), "Passed", null);
		testCaseResults.add(caseResult);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// Screenshot.takeScreenshot(driver, result.getName());

		System.out.println("Failed");
		caseResult = new TestCaseResult(result.getName(), "Failed", null);
		failCount = failCount + 1;
		testCaseResults.add(caseResult);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		testCaseResults = TestCase.prepareTestCaseResult(testCaseResults);
		MailSending.mailTestcasesResult(testCaseResults, passcount, failCount);

		System.out.println("Started code cleanup");
		FailedTestCases.codecleanup();
		passcount = 0;
		failCount = 0;
		testCaseResults.clear();
	}

}

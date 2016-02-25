package com.craftsvilla.dataobjects;

public class TestCaseResult {
	String status;
	String testCaseName;

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "TestCaseResult [status=" + status + ", testCaseName=" + testCaseName + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TestCaseResult(String testCaseName, String status) {
		super();
		this.status = status;
		this.testCaseName = testCaseName;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

}

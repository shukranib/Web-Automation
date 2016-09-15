package com.craftsvilla.dataobjects;

public class TestCaseResult {
	String status;
	String testCaseName;
	String Severity;

	public String getStatus() {
		return status;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	@Override
	public String toString() {
		return "TestCaseResult [status=" + status + ", testCaseName=" + testCaseName + ", Severity=" + Severity + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TestCaseResult(String testCaseName, String status, String severity) {
		super();
		this.status = status;
		this.testCaseName = testCaseName;
		Severity = severity;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

}

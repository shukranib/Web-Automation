package com.craftsvilla.dataobjects;

public class TestCaseBo {
	String testCaseName;
	String status;
	String ModuleName;
	String Severity;

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModuleName() {
		return ModuleName;
	}

	public TestCaseBo(String testCaseName, String status, String moduleName, String severity) {
		super();
		this.testCaseName = testCaseName;
		this.status = status;
		ModuleName = moduleName;
		Severity = severity;
	}

	@Override
	public String toString() {
		return "TestCaseBo [testCaseName=" + testCaseName + ", status=" + status + ", ModuleName=" + ModuleName
				+ ", Severity=" + Severity + "]";
	}

	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
}

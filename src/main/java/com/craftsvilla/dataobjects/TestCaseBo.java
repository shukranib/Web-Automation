package com.craftsvilla.dataobjects;

public class TestCaseBo {
	String testCaseName;
	String status;
	String ModuleName;

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TestCaseBo(String testCaseName, String status, String moduleName) {
		super();
		this.testCaseName = testCaseName;
		this.status = status;
		ModuleName = moduleName;
	}

	public String getModuleName() {
		return ModuleName;
	}

	@Override
	public String toString() {
		return "TestCaseBo [testCaseName=" + testCaseName + ", status=" + status + ", ModuleName=" + ModuleName + "]";
	}

	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
}

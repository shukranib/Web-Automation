package com.craftsvilla.dataobjects;

public class TestDataBO {
	String fieldName;
	String testData;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public TestDataBO(String fieldName, String testData) {
		super();
		this.fieldName = fieldName;
		this.testData = testData;
	}

	@Override
	public String toString() {
		return "TestDataBO [fieldName=" + fieldName + ", testData=" + testData + "]";
	}

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}

}

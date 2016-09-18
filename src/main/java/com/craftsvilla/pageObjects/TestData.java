package com.craftsvilla.pageObjects;

import com.craftsvilla.framework.GetTestData;

public class TestData {

	static public GetTestData testData = new GetTestData();

	static public String successMessage_sharewishlist = "successMessage_sharewishlist";

	static public String debitCardName = testData.getTestData("debitCardName");
	static public String debitCardNo = testData.getTestData("debitCardNo");
	static public String debitCardExpiraryMonth = testData.getTestData("debitCardExpiraryMonth");
	static public String debitCardExpiraryYear = testData.getTestData("debitCardExpiraryYear");
	static public String debitCardCsvNo = testData.getTestData("debitCardCsvNo");
	static public String userNameLogin = testData.getTestData("userNameLogin");
	static public String passWordLogin = testData.getTestData("passWordLogin");
	static public String firstName = testData.getTestData("firstName");
	static public String lastName = testData.getTestData("lastName");
	static public String emailIdRegister = testData.getTestData("emailIdRegister");
	static public String passWordRegister = testData.getTestData("passWordRegister");
	static public String passWordConfirmRegister = testData.getTestData("passWordConfirmRegister");
	static public String mobileNo = testData.getTestData("mobileNo");
	static public String ProductCategorysarees = testData.getTestData("ProductCategory-sarees");
	static public String firstNameBillingInfo = testData.getTestData("firstNameBillingInfo");
	static public String lastName_BillingInfo = testData.getTestData("lastName_BillingInfo");
	static public String street1_BillingInfo = testData.getTestData("street1_BillingInfo");
	static public String street2_BillingInfo = testData.getTestData("street2_BilligInfo");
	static public String city_BillingInfo = testData.getTestData("city_BillingInfo");
	static public String postcode_BillingInfo = testData.getTestData("postcode_BillingInfo");
	static public String country_BillingInfo = testData.getTestData("country_BillingInfo");
	static public String regoin_BillingInfo = testData.getTestData("regoin_BillingInfo");
	static public String telephone_BillingInfo = testData.getTestData("telephone_BillingInfo");
	static public String forgotPassword_emailID = testData.getTestData("forgotPassword_emailID");
	static public String successMessage_fogotPassword = testData.getTestData("successMessage_fogotPassword");
	static public String errorMessage_forgotPassword = testData.getTestData("errorMessage_forgotPassword");
	static public String button_searchText = testData.getTestData("Text-to-search");

}

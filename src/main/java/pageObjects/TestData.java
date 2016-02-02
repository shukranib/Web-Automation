package pageObjects;

import com.craftsvilla.framework.GetTestData;

public class TestData {
	static GetTestData testData = new GetTestData();
	static String userNameLogin = testData.getTestData("userNameLogin");
	static String passWordLogin = testData.getTestData("passWordLogin");
	static String firstName = testData.getTestData("firstName");
	static String lastName = testData.getTestData("lastName");
	static String emailIdRegister = testData.getTestData("emailIdRegister");
	static String passWordRegister = testData.getTestData("passWordRegister");
	static String passWordConfirmRegister = testData.getTestData("passWordConfirmRegister");
	static String mobileNo = testData.getTestData("mobileNo");
	static String ProductCategorysarees = testData.getTestData("ProductCategory-sarees");
	static String firstNameBillingInfo = testData.getTestData("firstNameBillingInfo");
	static String lastName_BillingInfo = testData.getTestData("lastName_BillingInfo");
	static String street1_BillingInfo = testData.getTestData("street1_BillingInfo");
	static String street2_BillingInfo = testData.getTestData("street2_BilligInfo");
	static String city_BillingInfo = testData.getTestData("city_BillingInfo");
	static String postcode_BillingInfo = testData.getTestData("postcode_BillingInfo");
	static String country_BillingInfo = testData.getTestData("country_BillingInfo");
	static String regoin_BillingInfo = testData.getTestData("regoin_BillingInfo");
	static String telephone_BillingInfo = testData.getTestData("telephone_BillingInfo");
	static String forgotPassword_emailID = testData.getTestData("forgotPassword_emailID");
	static String successMessage_fogotPassword = testData.getTestData("successMessage_fogotPassword");
	static String errorMessage_forgotPassword = testData.getTestData("errorMessage_forgotPassword");
	static String button_searchText = testData.getTestData("Text-to-search");

	public static String getButton_searchText() {
		return button_searchText;
	}

	public static void setButton_searchText(String button_searchText) {
		TestData.button_searchText = button_searchText;
	}

	public static String getSuccessMessage_fogotPassword() {
		return successMessage_fogotPassword;
	}

	public static void setSuccessMessage_fogotPassword(String successMessage_fogotPassword) {
		TestData.successMessage_fogotPassword = successMessage_fogotPassword;
	}

	public static String getErrorMessage_forgotPassword() {
		return errorMessage_forgotPassword;
	}

	public static void setErrorMessage_forgotPassword(String errorMessage_forgotPassword) {
		TestData.errorMessage_forgotPassword = errorMessage_forgotPassword;
	}

	public static GetTestData getTestData() {
		return testData;
	}

	public static void setTestData(GetTestData testData) {
		TestData.testData = testData;
	}

	public static String getUserNameLogin() {
		return userNameLogin;
	}

	public static void setUserNameLogin(String userNameLogin) {
		TestData.userNameLogin = userNameLogin;
	}

	public static String getPassWordLogin() {
		return passWordLogin;
	}

	public static void setPassWordLogin(String passWordLogin) {
		TestData.passWordLogin = passWordLogin;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		TestData.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		TestData.lastName = lastName;
	}

	public static String getEmailIdRegister() {
		return emailIdRegister;
	}

	public static void setEmailIdRegister(String emailIdRegister) {
		TestData.emailIdRegister = emailIdRegister;
	}

	public static String getPassWordRegister() {
		return passWordRegister;
	}

	public static void setPassWordRegister(String passWordRegister) {
		TestData.passWordRegister = passWordRegister;
	}

	public static String getPassWordConfirmRegister() {
		return passWordConfirmRegister;
	}

	public static void setPassWordConfirmRegister(String passWordConfirmRegister) {
		TestData.passWordConfirmRegister = passWordConfirmRegister;
	}

	public static String getMobileNo() {
		return mobileNo;
	}

	public static void setMobileNo(String mobileNo) {
		TestData.mobileNo = mobileNo;
	}

	public static String getProductCategorysarees() {
		return ProductCategorysarees;
	}

	public static void setProductCategorysarees(String productCategorysarees) {
		ProductCategorysarees = productCategorysarees;
	}

	public static String getFirstNameBillingInfo() {
		return firstNameBillingInfo;
	}

	public static void setFirstNameBillingInfo(String firstNameBillingInfo) {
		TestData.firstNameBillingInfo = firstNameBillingInfo;
	}

	public static String getLastName_BillingInfo() {
		return lastName_BillingInfo;
	}

	public static void setLastName_BillingInfo(String lastName_BillingInfo) {
		TestData.lastName_BillingInfo = lastName_BillingInfo;
	}

	public static String getStreet1_BillingInfo() {
		return street1_BillingInfo;
	}

	public static void setStreet1_BillingInfo(String street1_BillingInfo) {
		TestData.street1_BillingInfo = street1_BillingInfo;
	}

	public static String getStreet2_BillingInfo() {
		return street2_BillingInfo;
	}

	public static void setStreet2_BillingInfo(String street2_BillingInfo) {
		TestData.street2_BillingInfo = street2_BillingInfo;
	}

	public static String getCity_BillingInfo() {
		return city_BillingInfo;
	}

	public static void setCity_BillingInfo(String city_BillingInfo) {
		TestData.city_BillingInfo = city_BillingInfo;
	}

	public static String getPostcode_BillingInfo() {
		return postcode_BillingInfo;
	}

	public static void setPostcode_BillingInfo(String postcode_BillingInfo) {
		TestData.postcode_BillingInfo = postcode_BillingInfo;
	}

	public static String getCountry_BillingInfo() {
		return country_BillingInfo;
	}

	public static void setCountry_BillingInfo(String country_BillingInfo) {
		TestData.country_BillingInfo = country_BillingInfo;
	}

	public static String getRegoin_BillingInfo() {
		return regoin_BillingInfo;
	}

	public static void setRegoin_BillingInfo(String regoin_BillingInfo) {
		TestData.regoin_BillingInfo = regoin_BillingInfo;
	}

	public static String getTelephone_BillingInfo() {
		return telephone_BillingInfo;
	}

	public static void setTelephone_BillingInfo(String telephone_BillingInfo) {
		TestData.telephone_BillingInfo = telephone_BillingInfo;
	}

	public static String getForgotPassword_emailID() {
		return forgotPassword_emailID;
	}

	public static void setForgotPassword_emailID(String forgotPassword_emailID) {
		TestData.forgotPassword_emailID = forgotPassword_emailID;
	}

}

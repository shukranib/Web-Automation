package com.craftsvilla.dataobjects;

public class BrowserResult {
	public String OSVersion;
	public String BrowserName;
	public String BrowserVersion;
	public int totalpass;
	public int totalfailed;
	public int totalexcuted;

	public String getOSVersion() {
		return OSVersion;
	}

	public void setOSVersion(String oSVersion) {
		OSVersion = oSVersion;
	}

	public String getBrowserName() {
		return BrowserName;
	}

	public void setBrowserName(String browserName) {
		BrowserName = browserName;
	}

	public String getBrowserVersion() {
		return BrowserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		BrowserVersion = browserVersion;
	}

	public int getTotalpass() {
		return totalpass;
	}

	public void setTotalpass(int totalpass) {
		this.totalpass = totalpass;
	}

	public int getTotalfailed() {
		return totalfailed;
	}

	public void setTotalfailed(int totalfailed) {
		this.totalfailed = totalfailed;
	}

	public int getTotalexcuted() {
		return totalexcuted;
	}

	public void setTotalexcuted(int totalexcuted) {
		this.totalexcuted = totalexcuted;
	}

	public BrowserResult(String oSVersion, String browserName, String browserVersion, int totalpass, int totalfailed,
			int totalexcuted) {
		super();
		OSVersion = oSVersion;
		BrowserName = browserName;
		BrowserVersion = browserVersion;
		this.totalpass = totalpass;
		this.totalfailed = totalfailed;
		this.totalexcuted = totalexcuted;
	}

	@Override
	public String toString() {
		return "BrowserResult [OSVersion=" + OSVersion + ", BrowserName=" + BrowserName + ", BrowserVersion="
				+ BrowserVersion + ", totalpass=" + totalpass + ", totalfailed=" + totalfailed + ", totalexcuted="
				+ totalexcuted + "]";
	}

}

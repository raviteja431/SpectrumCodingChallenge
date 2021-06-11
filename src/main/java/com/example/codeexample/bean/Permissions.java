package com.example.codeexample.bean;

import java.util.ArrayList;

public class Permissions {
	private String exemptionText;
	private ArrayList<Licenses> licenses;
	private String usageType;
	public String getExemptionText() {
		return exemptionText;
	}
	public void setExemptionText(String exemptionText) {
		this.exemptionText = exemptionText;
	}
	
	public ArrayList<Licenses> getLicenses() {
		return licenses;
	}
	public void setLicenses(ArrayList<Licenses> licenses) {
		this.licenses = licenses;
	}
	public String getUsageType() {
		return usageType;
	}
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	
}

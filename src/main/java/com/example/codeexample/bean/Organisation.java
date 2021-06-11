package com.example.codeexample.bean;

import java.util.ArrayList;

public class Organisation {
	private String organization;
	private String release_count;
	private String total_labor_hours;
	private String all_in_production;
	private ArrayList<String> licenses;
	private ArrayList<String> most_active_months;
	
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getRelease_count() {
		return release_count;
	}
	public void setRelease_count(String release_count) {
		this.release_count = release_count;
	}
	public String getTotal_labor_hours() {
		return total_labor_hours;
	}
	public void setTotal_labor_hours(String total_labor_hours) {
		this.total_labor_hours = total_labor_hours;
	}
	public String getAll_in_production() {
		return all_in_production;
	}
	public void setAll_in_production(String all_in_production) {
		this.all_in_production = all_in_production;
	}
	public ArrayList<String> getLicenses() {
		return licenses;
	}
	public void setLicenses(ArrayList<String> licenses) {
		this.licenses = licenses;
	}
	public ArrayList<String> getMost_active_months() {
		return most_active_months;
	}
	public void setMost_active_months(ArrayList<String> most_active_months) {
		this.most_active_months = most_active_months;
	}
	
	
}

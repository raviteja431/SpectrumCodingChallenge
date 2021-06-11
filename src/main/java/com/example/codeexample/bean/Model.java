package com.example.codeexample.bean;

import java.util.ArrayList;

public class Model {
	private String agency;
	private MeasurementType measurementType;
	private ArrayList<Releases> releases;
	private String version;
	
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public MeasurementType getMeasurementType() {
		return measurementType;
	}
	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}
	
	
	public ArrayList<Releases> getReleases() {
		return releases;
	}
	public void setReleases(ArrayList<Releases> releases) {
		this.releases = releases;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}

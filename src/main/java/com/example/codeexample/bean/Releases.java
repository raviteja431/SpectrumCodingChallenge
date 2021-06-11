package com.example.codeexample.bean;

import java.util.ArrayList;

public class Releases {
	private Contact contact;
	private date date;
	private String description;
	private String laborHours;
	private String name;
	private String organization;
	private Permissions permissions;
	private String repositoryURL;
	private String status;
	private ArrayList<String> tags;
	private String vcs;
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public date getDate() {
		return date;
	}
	public void setDate(date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLaborHours() {
		return laborHours;
	}
	public void setLaborHours(String laborHours) {
		this.laborHours = laborHours;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Permissions getPermissions() {
		return permissions;
	}
	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	public String getRepositoryURL() {
		return repositoryURL;
	}
	public void setRepositoryURL(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getVcs() {
		return vcs;
	}
	public void setVcs(String vcs) {
		this.vcs = vcs;
	}
	
	
}

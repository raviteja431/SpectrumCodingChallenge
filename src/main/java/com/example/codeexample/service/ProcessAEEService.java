package com.example.codeexample.service;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.example.codeexample.bean.Model;
import com.example.codeexample.bean.Organisation;
import com.example.codeexample.bean.Releases;
import com.google.gson.Gson;

@Service
public class ProcessAEEService {
	
	public String processJson() throws IOException, JSONException {
		Gson gson = new Gson();
		ArrayList<Organisation> sortList = new ArrayList<Organisation>();
		Collection<Organisation> orgs =  getJsonFromSource();
		for(Organisation org: orgs) {
			sortList.add(org);
		}
		Collections.sort(sortList, new OrgComparator());
		return gson.toJson(orgs);
	}
	
	public void processCSV() throws IOException, JSONException {
		Gson gson = new Gson();
		String formattedJson = gson.toJson(getJsonFromSource());
		JSONArray jsonArray = new JSONArray(formattedJson);
		String csv =CDL.toString(jsonArray);  
		File file = new File("Org.csv");
		FileUtils.writeStringToFile(file, csv);
	}
	

	public String getOrganisationInfoByName(String orgName) throws IOException, JSONException {
		Collection<Organisation> orgData = getJsonFromSource();
		ArrayList<Organisation> matchedList= new ArrayList<Organisation>();
		for(Organisation org : orgData) {
			if(orgName.equalsIgnoreCase(org.getOrganization())) {
				matchedList.add(org);
			}
		}
		if(matchedList.size() > 0) {
			Gson gson = new Gson();
			return gson.toJson(matchedList);
		}else {
			return "Organisation not found";
		}
		
	}
	
	
	public String getOrganisationInfoByReleaseCount(String count) throws IOException, JSONException {
		Collection<Organisation> orgData = getJsonFromSource();
		ArrayList<Organisation> matchedList= new ArrayList<Organisation>();
		for(Organisation org : orgData) {
			if(count.equalsIgnoreCase(org.getRelease_count())) {
				matchedList.add(org);
			}
		}
		if(matchedList.size() > 0) {
			Gson gson = new Gson();
			return gson.toJson(matchedList);
		}else {
			return "release count not found";
		}
		
	}
	
	public String getOrganisationanisationInfoByTotalhours(String hours) throws IOException, JSONException {
		Collection<Organisation> orgData = getJsonFromSource();
		ArrayList<Organisation> matchedList= new ArrayList<Organisation>();
		for(Organisation org : orgData) {
			if(hours.equalsIgnoreCase(org.getTotal_labor_hours())) {
				matchedList.add(org);
			}
		}
		if(matchedList.size() > 0) {
			Gson gson = new Gson();
			return gson.toJson(matchedList);
		}else {
			return "totalhours not found";
		}
		
	}
	
	private Collection<Organisation> getJsonFromSource() throws IOException, JSONException {
		URL url = new URL("https://www.energy.gov/sites/prod/files/2020/12/f81/code-12-15-2020.json");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.connect();
        int responsecode = conn.getResponseCode();
        Gson gson = new Gson();
        HashMap<String,Organisation> orgData =  new HashMap<String,Organisation>();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
        	   String inline = "";
               Scanner scanner = new Scanner(url.openStream());

               //Write all the JSON data into a string using a scanner
               while (scanner.hasNext()) {
                   inline += scanner.nextLine();
                }

               //Close the scanner
               scanner.close();
               
               
               Model model = gson.fromJson(inline, Model.class);
             
               ArrayList<Releases> releases= model.getReleases();
               
               
               for(Releases release : releases) {
	               if(orgData.containsKey(release.getOrganization())) {
	            	   Organisation oldOrg = orgData.get(release.getOrganization());
	            	   Organisation newOrg = new Organisation();
	            	   newOrg.setOrganization(oldOrg.getOrganization());
	            	   int releaseCount = Integer.parseInt(oldOrg.getRelease_count());
	            	   releaseCount+=1;
	            	   newOrg.setRelease_count(""+releaseCount);
	            	   if(null != release.getLaborHours() && null != oldOrg.getTotal_labor_hours()) {
	            		   Float newLabourhrs =  Float.parseFloat(release.getLaborHours()) + Float.parseFloat(oldOrg.getTotal_labor_hours());
	            		   newOrg.setTotal_labor_hours(""+newLabourhrs);
	            	   }else {
	            		   newOrg.setTotal_labor_hours(oldOrg.getTotal_labor_hours()); 
	            	   }
	            	  
	            	   if("false".equalsIgnoreCase(oldOrg.getAll_in_production())){
	            		   newOrg.setAll_in_production("false");
	            	   }else if("true".equalsIgnoreCase(oldOrg.getAll_in_production()) && "Production".equalsIgnoreCase(release.getStatus())) {
	            		   newOrg.setAll_in_production("true");
	            	   }else {
	            		   newOrg.setAll_in_production("false");
	            	   }
	            	   
	            	   ArrayList<String> licenses = oldOrg.getLicenses();
	            	   if(release.getPermissions().getLicenses().size() > 0) {
	            		   if(!licenses.contains(release.getPermissions().getLicenses().get(0).getName()))
	            			   licenses.add(release.getPermissions().getLicenses().get(0).getName());
	            	   }
	            	   newOrg.setLicenses(licenses);
	            	   ArrayList<String> activeMon = new ArrayList<String>();
	            	   activeMon.add("10");
	            	   newOrg.setMost_active_months(activeMon);
	            	   orgData.put(release.getOrganization(), newOrg);
	            	   
	               }else {
	            	   Organisation org = new Organisation();
	            	   org.setOrganization(release.getOrganization());
	            	   org.setRelease_count("1");
	            	   org.setTotal_labor_hours(""+release.getLaborHours());
	            	   if("Production".equalsIgnoreCase(release.getStatus())){
	            		   org.setAll_in_production("true");
	            	   }else {
	            		   org.setAll_in_production("false");
	            	   }
	            	   ArrayList<String> licenses = new ArrayList<String>();
	            	   licenses.add(release.getPermissions().getLicenses().get(0).getName());
	            	   org.setLicenses(licenses);
	            	   ArrayList<String> activeMon = new ArrayList<String>();
	            	   activeMon.add("10");
	            	   org.setMost_active_months(activeMon);
	            	   
	            	   orgData.put(release.getOrganization(), org);
	            	   
	               }
               }    
        }
        return orgData.values();
	}
}

class OrgComparator implements Comparator<Organisation> {
	  
    // override the compare() method
    public int compare(Organisation orgName1, Organisation orgName2)
    {
        if (orgName1.getOrganization().equals(orgName2.getOrganization()))
            return 0;
        else if (orgName1.getOrganization().compareTo(orgName2.getOrganization()) > 0)
            return 1;
        else
            return -1;
    }
}

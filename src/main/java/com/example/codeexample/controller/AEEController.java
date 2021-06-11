package com.example.codeexample.controller;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeexample.service.ProcessAEEService;

@RestController
@RequestMapping(path = "/v1")
public class AEEController {
	
	@Autowired
	private ProcessAEEService service;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfo")
	public String getOrganisationJson() throws IOException, JSONException {
		return service.processJson();
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/generateCSV")
	public void getOrganisationCSV() throws IOException, JSONException {
		 service.processCSV();
	}
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByName/{orgName}")
	public String getOrganisationDataByName(@PathVariable(value = "orgName") String orgName) throws IOException, JSONException {
		
		return service.getOrganisationInfoByName(orgName);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByRelease/{count}")
	public String getOrganisationInfoByRelease(@PathVariable(value = "count") String count) throws IOException, JSONException {
		
		return service.getOrganisationInfoByReleaseCount(count);
	}
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByTotalHours/{hours}")
	public String getOrganisationInfoByTotalHours(@PathVariable(value = "hours") String hours) throws IOException, JSONException {
		
		return service.getOrganisationanisationInfoByTotalhours(hours);
	}

}

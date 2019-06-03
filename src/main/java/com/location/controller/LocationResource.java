package com.location.controller;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("locationController")
@RequestMapping("/api")
public class LocationResource {

	private static ResourceBundle rb = ResourceBundle.getBundle("application");
	private static Logger log = LoggerFactory.getLogger(LocationResource.class);

	private static String FS_BASE_URL = rb.getString("FOURSQUAREAPI_BASE_URL");

	@GetMapping("/searchLocation")
	public Object getLocationData(@RequestParam String searchTerm) {
		log.info("Inside getLocationData with search term : {}", searchTerm);

		return "search ing for location: " + searchTerm;
	}
}

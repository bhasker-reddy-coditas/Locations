package com.location.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.dto.VenuesResponseDTO;

@RestController("locationController")
@RequestMapping("/api")
public class LocationResource {

	private static final ResourceBundle rb = ResourceBundle.getBundle("application");
	private static final Logger log = LoggerFactory.getLogger(LocationResource.class);

	private static final String FS_BASE_URL = rb.getString("FOURSQUAREAPI_BASE_URL");

	@GetMapping("/searchVenues")
	public VenuesResponseDTO searchVenues(@RequestParam(value = "query", required = true) String strQuery,
			@RequestParam(value = "near", required = true) String strNear,
			@RequestParam(value = "intent", required = false) String strIntent,
			@RequestParam(value = "radius", required = true) String strRadius,
			@RequestParam(value = "limit", required = true) String strLimit) {

		log.info("Inside getLocationData with search term : {}", strQuery);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("client_id", rb.getString("FOURSQUARE.CLIENT_ID")));
		urlParameters.add(new BasicNameValuePair("client_secret", rb.getString("FOURSQUARE.CLIENT_SECRET")));
		urlParameters.add(new BasicNameValuePair("v", rb.getString("API_PARAM.v")));
		urlParameters.add(new BasicNameValuePair("query", strQuery));
		urlParameters.add(new BasicNameValuePair("near", strNear));
		urlParameters.add(new BasicNameValuePair("intent", strIntent));
		urlParameters.add(new BasicNameValuePair("radius", strRadius));
		urlParameters.add(new BasicNameValuePair("limit", strLimit));

		URIBuilder builder = null;
		JSONObject jsonResponse = null;
		StringBuilder sb = new StringBuilder();
		VenuesResponseDTO dtos = null;
		try {
			builder = new URIBuilder(FS_BASE_URL+"venues/search");
			builder.setParameters(urlParameters);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			URI uri = builder.build();
			HttpGet request = new HttpGet(uri);
			log.info("Generated Url : "+ uri.toString());

			HttpResponse response = httpClient.execute(request);
			String strResponse = "";
			BufferedReader rd = null;
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			while ((strResponse = rd.readLine()) != null) {
				sb.append(strResponse);
			}
			log.info("Response : "+ sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			 dtos = mapper.readValue(sb.toString(), VenuesResponseDTO.class);
			
			log.info("Converted JSON response into DTO : "+ dtos);
			
			jsonResponse = new JSONObject(sb.toString());
			log.info("jsonResponse : "+ jsonResponse);
		} catch (URISyntaxException | IOException e) {
			log.error("Error while creating URL : ", e);
		} catch (Exception exc) {
			log.error("Error  : ", exc);
		}
		return dtos;
	}
}

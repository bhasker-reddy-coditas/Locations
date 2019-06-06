package com.location.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.dto.Venue;
import com.location.dto.VenuesResponseDTO;
import com.location.dto.venue.VenueDetails;

@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Autowired
	private Environment environment;
	
	/**
	 * Helper method to form URL and create HttpGet instance
	 * 
	 * @param urlParameters
	 * @param endPointUri
	 * @return instance of HttpGet
	 */
	public HttpGet generateRequestUri(List<NameValuePair> urlParameters, String endPointUri) {
		log.info("Generate URL and create HttpGet request instance.");
		HttpGet request = null;
		try {
			URIBuilder builder = new URIBuilder(environment.getProperty("FOURSQUAREAPI_BASE_URL") + endPointUri);
			List<NameValuePair> commonUrlParameters = new ArrayList<NameValuePair>();
			commonUrlParameters
					.add(new BasicNameValuePair("client_id", environment.getProperty("FOURSQUARE.CLIENT_ID")));
			commonUrlParameters
					.add(new BasicNameValuePair("client_secret", environment.getProperty("FOURSQUARE.CLIENT_SECRET")));
			commonUrlParameters.add(new BasicNameValuePair("v", environment.getProperty("API_PARAM.v")));

			if (null != urlParameters && !urlParameters.isEmpty()) {
				commonUrlParameters.addAll(urlParameters);
			}

			builder.setParameters(commonUrlParameters);
			URI uri = builder.build();
			request = new HttpGet(uri);
			log.info("Generated Url : " + uri.toString());
		} catch (URISyntaxException e) {
			log.error("Error while generating Url - Request : " + e.getMessage());
		}
		return request;
	}

	/**
	 * Helper method to filter the API response based on the Category
	 * 
	 * @param venueResults
	 * @param strFilter
	 */
	public void filterResults(VenuesResponseDTO venueResults, String strFilter) {
		log.info("Filter Venue results - filter query {}", strFilter);
		List<Venue> filteredVenues = venueResults.getResponse().getVenues().parallelStream()
				.filter(venue -> venue.getCategories().stream()
						.anyMatch(category -> category.getName().toUpperCase().contains(strFilter.toUpperCase())))
				.collect(Collectors.toList());
		log.info("Filtered venues : " + filteredVenues);
		venueResults.getResponse().setVenues(filteredVenues);
	}
	
	/**
	 * Helper method to fetch Venue Details for the given Venue Id
	 * 
	 * @param venueId
	 * @return
	 */
	public VenueDetails getVenueDetails(String venueId) {
		log.info("Fetch venue details for the given venue Id : {}", venueId);
		String strResponse = "";
		BufferedReader rd = null;
		VenueDetails venueDetails = null;
		StringBuilder sb = new StringBuilder();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = generateRequestUri(null, "venues/" + venueId);

		try {
			HttpResponse response = httpClient.execute(request);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			while ((strResponse = rd.readLine()) != null) {
				sb.append(strResponse);
			}
			log.info("Response : " + sb.toString());
			ObjectMapper mapper = new ObjectMapper();

			venueDetails = mapper.readValue(sb.toString(), VenueDetails.class);
		} catch (IOException e) {
			log.error("Error while fetching Venue details for venue ID : {}", venueId);
		}
		return venueDetails;
	}
}

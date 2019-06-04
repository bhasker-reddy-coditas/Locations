package com.location.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.dto.Venue;
import com.location.dto.VenuesResponseDTO;
import com.location.dto.venue.VenueDetails;

@RestController("locationController")
@RequestMapping("/api")
public class LocationResource {

	private static final ResourceBundle rb = ResourceBundle.getBundle("application");
	private static final Logger log = LoggerFactory.getLogger(LocationResource.class);

	private static final String FS_BASE_URL = rb.getString("FOURSQUAREAPI_BASE_URL");

	/**
	 * Helper method to form URL and create HttpGet instance
	 * 
	 * @param urlParameters
	 * @param endPointUri
	 * @return instance of HttpGet
	 */
	private static HttpGet generateRequestUri(List<NameValuePair> urlParameters, String endPointUri) {
		log.info("Generate URL and create HttpGet request instance.");
		HttpGet request = null;
		try {
			URIBuilder builder = new URIBuilder(FS_BASE_URL + endPointUri);
			List<NameValuePair> commonUrlParameters = new ArrayList<NameValuePair>();
			commonUrlParameters.add(new BasicNameValuePair("client_id", rb.getString("FOURSQUARE.CLIENT_ID")));
			commonUrlParameters.add(new BasicNameValuePair("client_secret", rb.getString("FOURSQUARE.CLIENT_SECRET")));
			commonUrlParameters.add(new BasicNameValuePair("v", rb.getString("API_PARAM.v")));

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
	 * REST API end point to search Venues
	 * 
	 * @param strQuery
	 *            A search term to be applied against venue names.
	 * @param ll
	 *            required unless <b>strNear </b> is provided. Latitude and
	 *            longitude of the user’s location.
	 * @param strNear
	 *            required unless <b> ll </b>is provided. A string naming a place in
	 *            the world.
	 * @param strIntent
	 *            One of the <b>checkin, global, browse, match </b> values,
	 *            indicating your intent in performing the search.
	 * @param strRadius
	 *            Limit results to venues within this many meters of the specified
	 *            location.
	 * @param strLimit
	 *            Number of results to return, up to 50.
	 * @param strFilter
	 *            filter query to filter the API response
	 * @return the response DTO VenuesResponseDTO
	 */
	@GetMapping("/searchVenues")
	public VenuesResponseDTO searchVenues(@RequestParam(value = "query", required = true) String strQuery,
			@RequestParam(value = "ll", required = false) String ll,
			@RequestParam(value = "near", required = false) String strNear,
			@RequestParam(value = "intent", required = false) String strIntent,
			@RequestParam(value = "radius", required = false) String strRadius,
			@RequestParam(value = "limit", required = false) String strLimit,
			@RequestParam(value = "filter", required = false) String strFilter) {

		log.info("Inside getLocationData with search term : {}", strQuery);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		if (!StringUtils.isEmpty(ll)) {
			urlParameters.add(new BasicNameValuePair("ll", ll));
		} else if (!StringUtils.isEmpty(strNear)) {
			urlParameters.add(new BasicNameValuePair("near", strNear));
		}
		urlParameters.add(new BasicNameValuePair("query", strQuery));
		urlParameters.add(new BasicNameValuePair("intent", strIntent));
		urlParameters.add(new BasicNameValuePair("radius", strRadius));
		urlParameters.add(new BasicNameValuePair("limit", strLimit));

		StringBuilder sb = new StringBuilder();
		VenuesResponseDTO dtos = null;
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = generateRequestUri(urlParameters, "venues/search");
			HttpResponse response = httpClient.execute(request);
			String strResponse = "";
			BufferedReader rd = null;
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			while ((strResponse = rd.readLine()) != null) {
				sb.append(strResponse);
			}
			log.info("Venues Search Response : {}", sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			dtos = mapper.readValue(sb.toString(), VenuesResponseDTO.class);

			if (!StringUtils.isEmpty(strFilter)) {
				filterResults(dtos, strFilter);
			}

			for (Venue venue : dtos.getResponse().getVenues()) {
				VenueDetails venueDetails = getVenueDetails(venue.getId());
				venue.setVenueDetails(venueDetails);
			}

		} catch (IOException e) {
			log.error("Error while converting response : {}", e);
		} catch (Exception exc) {
			log.error("Error  : {}", exc);
		}
		return dtos;
	}

	/**
	 * Helper method to filter the API response based on the Category
	 * 
	 * @param venueResults
	 * @param strFilter
	 */
	private void filterResults(VenuesResponseDTO venueResults, String strFilter) {
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
	private VenueDetails getVenueDetails(String venueId) {
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

package com.location.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.location.dto.Venue;
import com.location.dto.VenuesResponseDTO;
import com.location.dto.venue.VenueDetails;
import com.location.service.LocationService;

@RestController("locationController")
@RequestMapping("/api")
public class LocationResource {

	private static final Logger log = LoggerFactory.getLogger(LocationResource.class);

	@Autowired
	private LocationService locationService;

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
			HttpGet request = locationService.generateRequestUri(urlParameters, "venues/search");
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
				locationService.filterResults(dtos, strFilter);
			}

			for (Venue venue : dtos.getResponse().getVenues()) {
				VenueDetails venueDetails = locationService.getVenueDetails(venue.getId());
				venue.setVenueDetails(venueDetails);
			}

		} catch (IOException e) {
			log.error("Error while converting response : {}", e);
		} catch (Exception exc) {
			log.error("Error  : {}", exc);
		}
		return dtos;
	}
}

package com.location.service;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;

import com.location.dto.VenuesResponseDTO;
import com.location.dto.venue.VenueDetails;

public interface LocationService {

	public HttpGet generateRequestUri(List<NameValuePair> urlParameters, String endPointUri);

	public void filterResults(VenuesResponseDTO venueResults, String strFilter);

	public VenueDetails getVenueDetails(String venueId);

}

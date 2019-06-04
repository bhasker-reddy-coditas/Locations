package com.location.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venues",
    "geocode"
})
@JsonIgnoreProperties(value = { "geocode" })
public class Response implements Serializable {

	@JsonProperty("venues")
	private List<Venue> venues = new ArrayList<Venue>();
	@JsonProperty("geocode")
	private Geocode geocode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 5701697607386752562L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Response() {
	}

	/**
	 * 
	 * @param geocode
	 * @param venues
	 */
	public Response(List<Venue> venues, Geocode geocode) {
		super();
		this.venues = venues;
		this.geocode = geocode;
	}

	@JsonProperty("venues")
	public List<Venue> getVenues() {
		return venues;
	}

	@JsonProperty("venues")
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	public Response withVenues(List<Venue> venues) {
		this.venues = venues;
		return this;
	}

	@JsonProperty("geocode")
	public Geocode getGeocode() {
		return geocode;
	}

	@JsonProperty("geocode")
	public void setGeocode(Geocode geocode) {
		this.geocode = geocode;
	}

	public Response withGeocode(Geocode geocode) {
		this.geocode = geocode;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Response withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

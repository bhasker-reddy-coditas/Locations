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
	"lat", "lng", "labeledLatLngs",
	"postalCode", "cc", "city",
	"state", "country", 
	"formattedAddress",
	"address", "crossStreet" })
@JsonIgnoreProperties(value = { "labeledLatLngs" })
public class Location implements Serializable {

	@JsonProperty("lat")
	private Double lat;
	@JsonProperty("lng")
	private Double lng;
	@JsonProperty("labeledLatLngs")
	private List<LabeledLatLng> labeledLatLngs = new ArrayList<LabeledLatLng>();
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("cc")
	private String cc;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("country")
	private String country;
	@JsonProperty("formattedAddress")
	private List<String> formattedAddress = new ArrayList<String>();
	@JsonProperty("address")
	private String address;
	@JsonProperty("crossStreet")
	private String crossStreet;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -6259480867341334978L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Location() {
	}

	/**
	 * 
	 * @param postalCode
	 * @param address
	 * @param labeledLatLngs
	 * @param state
	 * @param formattedAddress
	 * @param lng
	 * @param cc
	 * @param lat
	 * @param crossStreet
	 * @param country
	 * @param city
	 */
	public Location(Double lat, Double lng, List<LabeledLatLng> labeledLatLngs, String postalCode, String cc,
			String city, String state, String country, List<String> formattedAddress, String address,
			String crossStreet) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.labeledLatLngs = labeledLatLngs;
		this.postalCode = postalCode;
		this.cc = cc;
		this.city = city;
		this.state = state;
		this.country = country;
		this.formattedAddress = formattedAddress;
		this.address = address;
		this.crossStreet = crossStreet;
	}

	@JsonProperty("lat")
	public Double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Location withLat(Double lat) {
		this.lat = lat;
		return this;
	}

	@JsonProperty("lng")
	public Double getLng() {
		return lng;
	}

	@JsonProperty("lng")
	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Location withLng(Double lng) {
		this.lng = lng;
		return this;
	}

	@JsonProperty("labeledLatLngs")
	public List<LabeledLatLng> getLabeledLatLngs() {
		return labeledLatLngs;
	}

	@JsonProperty("labeledLatLngs")
	public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
		this.labeledLatLngs = labeledLatLngs;
	}

	public Location withLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
		this.labeledLatLngs = labeledLatLngs;
		return this;
	}

	@JsonProperty("postalCode")
	public String getPostalCode() {
		return postalCode;
	}

	@JsonProperty("postalCode")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Location withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	@JsonProperty("cc")
	public String getCc() {
		return cc;
	}

	@JsonProperty("cc")
	public void setCc(String cc) {
		this.cc = cc;
	}

	public Location withCc(String cc) {
		this.cc = cc;
		return this;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	public Location withCity(String city) {
		this.city = city;
		return this;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	public Location withState(String state) {
		this.state = state;
		return this;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	public Location withCountry(String country) {
		this.country = country;
		return this;
	}

	@JsonProperty("formattedAddress")
	public List<String> getFormattedAddress() {
		return formattedAddress;
	}

	@JsonProperty("formattedAddress")
	public void setFormattedAddress(List<String> formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Location withFormattedAddress(List<String> formattedAddress) {
		this.formattedAddress = formattedAddress;
		return this;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	public Location withAddress(String address) {
		this.address = address;
		return this;
	}

	@JsonProperty("crossStreet")
	public String getCrossStreet() {
		return crossStreet;
	}

	@JsonProperty("crossStreet")
	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}

	public Location withCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
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

	public Location withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

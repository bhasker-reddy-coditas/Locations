package com.location.dto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lng"
})
public class Sw implements Serializable {

	@JsonProperty("lat")
	private Double lat;
	@JsonProperty("lng")
	private Double lng;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7849892693885071770L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Sw() {
	}

	/**
	 * 
	 * @param lng
	 * @param lat
	 */
	public Sw(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	@JsonProperty("lat")
	public Double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Sw withLat(Double lat) {
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

	public Sw withLng(Double lng) {
		this.lng = lng;
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

	public Sw withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

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
    "center",
    "bounds"
})
public class Geometry implements Serializable {

	@JsonProperty("center")
	private Center center;
	@JsonProperty("bounds")
	private Bounds bounds;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6878076951382013200L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Geometry() {
	}

	/**
	 * 
	 * @param bounds
	 * @param center
	 */
	public Geometry(Center center, Bounds bounds) {
		super();
		this.center = center;
		this.bounds = bounds;
	}

	@JsonProperty("center")
	public Center getCenter() {
		return center;
	}

	@JsonProperty("center")
	public void setCenter(Center center) {
		this.center = center;
	}

	public Geometry withCenter(Center center) {
		this.center = center;
		return this;
	}

	@JsonProperty("bounds")
	public Bounds getBounds() {
		return bounds;
	}

	@JsonProperty("bounds")
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	public Geometry withBounds(Bounds bounds) {
		this.bounds = bounds;
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

	public Geometry withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}


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
		"ne",
		"sw"
})
public class Bounds implements Serializable {

	@JsonProperty("ne")
	private Ne ne;
	@JsonProperty("sw")
	private Sw sw;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -6058960375166832793L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Bounds() {
	}

	/**
	 * 
	 * @param ne
	 * @param sw
	 */
	public Bounds(Ne ne, Sw sw) {
		super();
		this.ne = ne;
		this.sw = sw;
	}

	@JsonProperty("ne")
	public Ne getNe() {
		return ne;
	}

	@JsonProperty("ne")
	public void setNe(Ne ne) {
		this.ne = ne;
	}

	public Bounds withNe(Ne ne) {
		this.ne = ne;
		return this;
	}

	@JsonProperty("sw")
	public Sw getSw() {
		return sw;
	}

	@JsonProperty("sw")
	public void setSw(Sw sw) {
		this.sw = sw;
	}

	public Bounds withSw(Sw sw) {
		this.sw = sw;
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

	public Bounds withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

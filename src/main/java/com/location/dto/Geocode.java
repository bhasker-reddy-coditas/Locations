package com.location.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "what",
    "where",
    "feature",
    "parents"
})
public class Geocode implements Serializable {

	@JsonProperty("what")
	private String what;
	@JsonProperty("where")
	private String where;
	@JsonProperty("feature")
	private Feature feature;
	@JsonProperty("parents")
	private List<Object> parents = new ArrayList<Object>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4321186454070773505L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Geocode() {
	}

	/**
	 * 
	 * @param parents
	 * @param what
	 * @param feature
	 * @param where
	 */
	public Geocode(String what, String where, Feature feature, List<Object> parents) {
		super();
		this.what = what;
		this.where = where;
		this.feature = feature;
		this.parents = parents;
	}

	@JsonProperty("what")
	public String getWhat() {
		return what;
	}

	@JsonProperty("what")
	public void setWhat(String what) {
		this.what = what;
	}

	public Geocode withWhat(String what) {
		this.what = what;
		return this;
	}

	@JsonProperty("where")
	public String getWhere() {
		return where;
	}

	@JsonProperty("where")
	public void setWhere(String where) {
		this.where = where;
	}

	public Geocode withWhere(String where) {
		this.where = where;
		return this;
	}

	@JsonProperty("feature")
	public Feature getFeature() {
		return feature;
	}

	@JsonProperty("feature")
	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Geocode withFeature(Feature feature) {
		this.feature = feature;
		return this;
	}

	@JsonProperty("parents")
	public List<Object> getParents() {
		return parents;
	}

	@JsonProperty("parents")
	public void setParents(List<Object> parents) {
		this.parents = parents;
	}

	public Geocode withParents(List<Object> parents) {
		this.parents = parents;
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

	public Geocode withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

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
    "id",
    "name",
    "location",
    "categories",
    "referralId",
    "hasPerk"
})
public class Venue implements Serializable {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("categories")
	private List<Category> categories = new ArrayList<Category>();
	@JsonProperty("referralId")
	private String referralId;
	@JsonProperty("hasPerk")
	private Boolean hasPerk;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -5885686674876821174L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Venue() {
	}

	/**
	 * 
	 * @param referralId
	 * @param id
	 * @param location
	 * @param name
	 * @param categories
	 * @param hasPerk
	 */
	public Venue(String id, String name, Location location, List<Category> categories, String referralId,
			Boolean hasPerk) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.categories = categories;
		this.referralId = referralId;
		this.hasPerk = hasPerk;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public Venue withId(String id) {
		this.id = id;
		return this;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Venue withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	public Venue withLocation(Location location) {
		this.location = location;
		return this;
	}

	@JsonProperty("categories")
	public List<Category> getCategories() {
		return categories;
	}

	@JsonProperty("categories")
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Venue withCategories(List<Category> categories) {
		this.categories = categories;
		return this;
	}

	@JsonProperty("referralId")
	public String getReferralId() {
		return referralId;
	}

	@JsonProperty("referralId")
	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public Venue withReferralId(String referralId) {
		this.referralId = referralId;
		return this;
	}

	@JsonProperty("hasPerk")
	public Boolean getHasPerk() {
		return hasPerk;
	}

	@JsonProperty("hasPerk")
	public void setHasPerk(Boolean hasPerk) {
		this.hasPerk = hasPerk;
	}

	public Venue withHasPerk(Boolean hasPerk) {
		this.hasPerk = hasPerk;
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

	public Venue withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

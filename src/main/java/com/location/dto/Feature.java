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
    "cc",
    "name",
    "displayName",
    "matchedName",
    "highlightedName",
    "woeType",
    "slug",
    "id",
    "longId",
    "geometry"
})
public class Feature implements Serializable {

	@JsonProperty("cc")
	private String cc;
	@JsonProperty("name")
	private String name;
	@JsonProperty("displayName")
	private String displayName;
	@JsonProperty("matchedName")
	private String matchedName;
	@JsonProperty("highlightedName")
	private String highlightedName;
	@JsonProperty("woeType")
	private Integer woeType;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("id")
	private String id;
	@JsonProperty("longId")
	private String longId;
	@JsonProperty("geometry")
	private Geometry geometry;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -399420944671918490L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Feature() {
	}

	/**
	 * 
	 * @param id
	 * @param highlightedName
	 * @param longId
	 * @param name
	 * @param matchedName
	 * @param slug
	 * @param displayName
	 * @param woeType
	 * @param cc
	 * @param geometry
	 */
	public Feature(String cc, String name, String displayName, String matchedName, String highlightedName,
			Integer woeType, String slug, String id, String longId, Geometry geometry) {
		super();
		this.cc = cc;
		this.name = name;
		this.displayName = displayName;
		this.matchedName = matchedName;
		this.highlightedName = highlightedName;
		this.woeType = woeType;
		this.slug = slug;
		this.id = id;
		this.longId = longId;
		this.geometry = geometry;
	}

	@JsonProperty("cc")
	public String getCc() {
		return cc;
	}

	@JsonProperty("cc")
	public void setCc(String cc) {
		this.cc = cc;
	}

	public Feature withCc(String cc) {
		this.cc = cc;
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

	public Feature withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("displayName")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("displayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Feature withDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	@JsonProperty("matchedName")
	public String getMatchedName() {
		return matchedName;
	}

	@JsonProperty("matchedName")
	public void setMatchedName(String matchedName) {
		this.matchedName = matchedName;
	}

	public Feature withMatchedName(String matchedName) {
		this.matchedName = matchedName;
		return this;
	}

	@JsonProperty("highlightedName")
	public String getHighlightedName() {
		return highlightedName;
	}

	@JsonProperty("highlightedName")
	public void setHighlightedName(String highlightedName) {
		this.highlightedName = highlightedName;
	}

	public Feature withHighlightedName(String highlightedName) {
		this.highlightedName = highlightedName;
		return this;
	}

	@JsonProperty("woeType")
	public Integer getWoeType() {
		return woeType;
	}

	@JsonProperty("woeType")
	public void setWoeType(Integer woeType) {
		this.woeType = woeType;
	}

	public Feature withWoeType(Integer woeType) {
		this.woeType = woeType;
		return this;
	}

	@JsonProperty("slug")
	public String getSlug() {
		return slug;
	}

	@JsonProperty("slug")
	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Feature withSlug(String slug) {
		this.slug = slug;
		return this;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public Feature withId(String id) {
		this.id = id;
		return this;
	}

	@JsonProperty("longId")
	public String getLongId() {
		return longId;
	}

	@JsonProperty("longId")
	public void setLongId(String longId) {
		this.longId = longId;
	}

	public Feature withLongId(String longId) {
		this.longId = longId;
		return this;
	}

	@JsonProperty("geometry")
	public Geometry getGeometry() {
		return geometry;
	}

	@JsonProperty("geometry")
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Feature withGeometry(Geometry geometry) {
		this.geometry = geometry;
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

	public Feature withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

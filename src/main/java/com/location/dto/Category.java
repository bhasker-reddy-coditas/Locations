
package com.location.dto;

import java.io.Serializable;
import java.util.HashMap;
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
    "id",
    "name",
    "pluralName",
    "shortName",
    "icon",
    "primary"
})

@JsonIgnoreProperties(value = { "icon", "shortName" })
public class Category implements Serializable {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("pluralName")
	private String pluralName;
	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("icon")
	private Icon icon;
	@JsonProperty("primary")
	private Boolean primary;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -818712883426256004L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Category() {
	}

	/**
	 * 
	 * @param id
	 * @param icon
	 * @param primary
	 * @param name
	 * @param shortName
	 * @param pluralName
	 */
	public Category(String id, String name, String pluralName, String shortName, Icon icon, Boolean primary) {
		super();
		this.id = id;
		this.name = name;
		this.pluralName = pluralName;
		this.shortName = shortName;
		this.icon = icon;
		this.primary = primary;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public Category withId(String id) {
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

	public Category withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("pluralName")
	public String getPluralName() {
		return pluralName;
	}

	@JsonProperty("pluralName")
	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}

	public Category withPluralName(String pluralName) {
		this.pluralName = pluralName;
		return this;
	}

	@JsonProperty("shortName")
	public String getShortName() {
		return shortName;
	}

	@JsonProperty("shortName")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Category withShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	@JsonProperty("icon")
	public Icon getIcon() {
		return icon;
	}

	@JsonProperty("icon")
	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Category withIcon(Icon icon) {
		this.icon = icon;
		return this;
	}

	@JsonProperty("primary")
	public Boolean getPrimary() {
		return primary;
	}

	@JsonProperty("primary")
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public Category withPrimary(Boolean primary) {
		this.primary = primary;
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

	public Category withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}

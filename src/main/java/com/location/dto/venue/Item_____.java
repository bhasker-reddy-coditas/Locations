
package com.location.dto.venue;

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
    "displayName",
    "displayValue",
    "priceTier"
})
public class Item_____ implements Serializable
{

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("displayValue")
    private String displayValue;
    @JsonProperty("priceTier")
    private Integer priceTier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2811023785482869716L;

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("displayValue")
    public String getDisplayValue() {
        return displayValue;
    }

    @JsonProperty("displayValue")
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @JsonProperty("priceTier")
    public Integer getPriceTier() {
        return priceTier;
    }

    @JsonProperty("priceTier")
    public void setPriceTier(Integer priceTier) {
        this.priceTier = priceTier;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

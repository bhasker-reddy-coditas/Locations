
package com.location.dto.venue;

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
    "isOpen",
    "isLocalHoliday",
    "timeframes"
})
public class Popular implements Serializable
{

    @JsonProperty("isOpen")
    private Boolean isOpen;
    @JsonProperty("isLocalHoliday")
    private Boolean isLocalHoliday;
    @JsonProperty("timeframes")
    private List<Timeframe> timeframes = new ArrayList<Timeframe>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -908689858043145268L;

    @JsonProperty("isOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("isOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @JsonProperty("isLocalHoliday")
    public Boolean getIsLocalHoliday() {
        return isLocalHoliday;
    }

    @JsonProperty("isLocalHoliday")
    public void setIsLocalHoliday(Boolean isLocalHoliday) {
        this.isLocalHoliday = isLocalHoliday;
    }

    @JsonProperty("timeframes")
    public List<Timeframe> getTimeframes() {
        return timeframes;
    }

    @JsonProperty("timeframes")
    public void setTimeframes(List<Timeframe> timeframes) {
        this.timeframes = timeframes;
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

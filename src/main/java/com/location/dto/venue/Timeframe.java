
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
    "days",
    "includesToday",
    "open",
    "segments"
})
public class Timeframe implements Serializable
{

    @JsonProperty("days")
    private String days;
    @JsonProperty("includesToday")
    private Boolean includesToday;
    @JsonProperty("open")
    private List<Open> open = new ArrayList<Open>();
    @JsonProperty("segments")
    private List<Object> segments = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3089929831649865324L;

    @JsonProperty("days")
    public String getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(String days) {
        this.days = days;
    }

    @JsonProperty("includesToday")
    public Boolean getIncludesToday() {
        return includesToday;
    }

    @JsonProperty("includesToday")
    public void setIncludesToday(Boolean includesToday) {
        this.includesToday = includesToday;
    }

    @JsonProperty("open")
    public List<Open> getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(List<Open> open) {
        this.open = open;
    }

    @JsonProperty("segments")
    public List<Object> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Object> segments) {
        this.segments = segments;
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

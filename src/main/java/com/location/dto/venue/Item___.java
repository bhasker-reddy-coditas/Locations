
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
    "id",
    "name",
    "description",
    "type",
    "user",
    "editable",
    "public",
    "collaborative",
    "url",
    "canonicalUrl",
    "createdAt",
    "updatedAt",
    "followers",
    "listItems"
})
public class Item___ implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("user")
    private User user;
    @JsonProperty("editable")
    private Boolean editable;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("url")
    private String url;
    @JsonProperty("canonicalUrl")
    private String canonicalUrl;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("updatedAt")
    private Integer updatedAt;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("listItems")
    private ListItems listItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8067165822519664033L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("editable")
    public Boolean getEditable() {
        return editable;
    }

    @JsonProperty("editable")
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("collaborative")
    public Boolean getCollaborative() {
        return collaborative;
    }

    @JsonProperty("collaborative")
    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("canonicalUrl")
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    @JsonProperty("canonicalUrl")
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("followers")
    public Followers getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    @JsonProperty("listItems")
    public ListItems getListItems() {
        return listItems;
    }

    @JsonProperty("listItems")
    public void setListItems(ListItems listItems) {
        this.listItems = listItems;
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

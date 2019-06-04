
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
    "createdAt",
    "text",
    "type",
    "canonicalUrl",
    "lang",
    "likes",
    "logView",
    "agreeCount",
    "disagreeCount",
    "todo",
    "user",
    "authorInteractionType"
})
public class Item_ implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("canonicalUrl")
    private String canonicalUrl;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("likes")
    private Likes_ likes;
    @JsonProperty("logView")
    private Boolean logView;
    @JsonProperty("agreeCount")
    private Integer agreeCount;
    @JsonProperty("disagreeCount")
    private Integer disagreeCount;
    @JsonProperty("todo")
    private Todo todo;
    @JsonProperty("user")
    private User user;
    @JsonProperty("authorInteractionType")
    private String authorInteractionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2674193277030743277L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("canonicalUrl")
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    @JsonProperty("canonicalUrl")
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty("likes")
    public Likes_ getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Likes_ likes) {
        this.likes = likes;
    }

    @JsonProperty("logView")
    public Boolean getLogView() {
        return logView;
    }

    @JsonProperty("logView")
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    @JsonProperty("agreeCount")
    public Integer getAgreeCount() {
        return agreeCount;
    }

    @JsonProperty("agreeCount")
    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    @JsonProperty("disagreeCount")
    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    @JsonProperty("disagreeCount")
    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    @JsonProperty("todo")
    public Todo getTodo() {
        return todo;
    }

    @JsonProperty("todo")
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("authorInteractionType")
    public String getAuthorInteractionType() {
        return authorInteractionType;
    }

    @JsonProperty("authorInteractionType")
    public void setAuthorInteractionType(String authorInteractionType) {
        this.authorInteractionType = authorInteractionType;
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

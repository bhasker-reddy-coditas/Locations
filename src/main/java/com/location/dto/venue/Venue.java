
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
    "id",
    "name",
    "contact",
    "location",
    "canonicalUrl",
    "categories",
    "verified",
    "stats",
    "price",
    "likes",
    "dislike",
    "ok",
    "rating",
    "ratingColor",
    "ratingSignals",
    "allowMenuUrlEdit",
    "beenHere",
    "specials",
    "photos",
    "reasons",
    "hereNow",
    "createdAt",
    "tips",
    "shortUrl",
    "timeZone",
    "listed",
    "popular",
    "pageUpdates",
    "inbox",
    "parent",
    "hierarchy",
    "attributes",
    "bestPhoto"
})
public class Venue implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("canonicalUrl")
    private String canonicalUrl;
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("likes")
    private Likes likes;
    @JsonProperty("dislike")
    private Boolean dislike;
    @JsonProperty("ok")
    private Boolean ok;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("ratingColor")
    private String ratingColor;
    @JsonProperty("ratingSignals")
    private Integer ratingSignals;
    @JsonProperty("allowMenuUrlEdit")
    private Boolean allowMenuUrlEdit;
    @JsonProperty("beenHere")
    private BeenHere beenHere;
    @JsonProperty("specials")
    private Specials specials;
    @JsonProperty("photos")
    private Photos photos;
    @JsonProperty("reasons")
    private Reasons reasons;
    @JsonProperty("hereNow")
    private HereNow hereNow;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("tips")
    private Tips tips;
    @JsonProperty("shortUrl")
    private String shortUrl;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("listed")
    private Listed listed;
    @JsonProperty("popular")
    private Popular popular;
    @JsonProperty("pageUpdates")
    private PageUpdates pageUpdates;
    @JsonProperty("inbox")
    private Inbox inbox;
    @JsonProperty("parent")
    private Parent parent;
    @JsonProperty("hierarchy")
    private List<Hierarchy> hierarchy = new ArrayList<Hierarchy>();
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("bestPhoto")
    private BestPhoto bestPhoto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3676473282909057243L;

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

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("canonicalUrl")
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    @JsonProperty("canonicalUrl")
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("likes")
    public Likes getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    @JsonProperty("dislike")
    public Boolean getDislike() {
        return dislike;
    }

    @JsonProperty("dislike")
    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("ratingColor")
    public String getRatingColor() {
        return ratingColor;
    }

    @JsonProperty("ratingColor")
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    @JsonProperty("ratingSignals")
    public Integer getRatingSignals() {
        return ratingSignals;
    }

    @JsonProperty("ratingSignals")
    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    @JsonProperty("allowMenuUrlEdit")
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    @JsonProperty("allowMenuUrlEdit")
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    @JsonProperty("beenHere")
    public BeenHere getBeenHere() {
        return beenHere;
    }

    @JsonProperty("beenHere")
    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    @JsonProperty("specials")
    public Specials getSpecials() {
        return specials;
    }

    @JsonProperty("specials")
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    @JsonProperty("photos")
    public Photos getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    @JsonProperty("reasons")
    public Reasons getReasons() {
        return reasons;
    }

    @JsonProperty("reasons")
    public void setReasons(Reasons reasons) {
        this.reasons = reasons;
    }

    @JsonProperty("hereNow")
    public HereNow getHereNow() {
        return hereNow;
    }

    @JsonProperty("hereNow")
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("tips")
    public Tips getTips() {
        return tips;
    }

    @JsonProperty("tips")
    public void setTips(Tips tips) {
        this.tips = tips;
    }

    @JsonProperty("shortUrl")
    public String getShortUrl() {
        return shortUrl;
    }

    @JsonProperty("shortUrl")
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("listed")
    public Listed getListed() {
        return listed;
    }

    @JsonProperty("listed")
    public void setListed(Listed listed) {
        this.listed = listed;
    }

    @JsonProperty("popular")
    public Popular getPopular() {
        return popular;
    }

    @JsonProperty("popular")
    public void setPopular(Popular popular) {
        this.popular = popular;
    }

    @JsonProperty("pageUpdates")
    public PageUpdates getPageUpdates() {
        return pageUpdates;
    }

    @JsonProperty("pageUpdates")
    public void setPageUpdates(PageUpdates pageUpdates) {
        this.pageUpdates = pageUpdates;
    }

    @JsonProperty("inbox")
    public Inbox getInbox() {
        return inbox;
    }

    @JsonProperty("inbox")
    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }

    @JsonProperty("parent")
    public Parent getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @JsonProperty("hierarchy")
    public List<Hierarchy> getHierarchy() {
        return hierarchy;
    }

    @JsonProperty("hierarchy")
    public void setHierarchy(List<Hierarchy> hierarchy) {
        this.hierarchy = hierarchy;
    }

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("bestPhoto")
    public BestPhoto getBestPhoto() {
        return bestPhoto;
    }

    @JsonProperty("bestPhoto")
    public void setBestPhoto(BestPhoto bestPhoto) {
        this.bestPhoto = bestPhoto;
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

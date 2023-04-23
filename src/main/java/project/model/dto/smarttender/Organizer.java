package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Title",
        "SeoTitle",
        "Usreou",
        "WebSite",
        "Address"
})
public class Organizer {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("SeoTitle")
    private String seoTitle;
    @JsonProperty("Usreou")
    private String usreou;
    @JsonProperty("WebSite")
    private String webSite;
    @JsonProperty("Address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("SeoTitle")
    public String getSeoTitle() {
        return seoTitle;
    }

    @JsonProperty("SeoTitle")
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    @JsonProperty("Usreou")
    public String getUsreou() {
        return usreou;
    }

    @JsonProperty("Usreou")
    public void setUsreou(String usreou) {
        this.usreou = usreou;
    }

    @JsonProperty("WebSite")
    public String getWebSite() {
        return webSite;
    }

    @JsonProperty("WebSite")
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", seoTitle='" + seoTitle + '\'' +
                ", usreou='" + usreou + '\'' +
                ", webSite='" + webSite + '\'' +
                ", address=" + address +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
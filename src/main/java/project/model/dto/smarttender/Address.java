package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "RegionId",
        "CountryId",
        "RegionTitle"
})
public class Address {
    @JsonProperty("RegionId")
    private Integer regionId;
    @JsonProperty("CountryId")
    private Integer countryId;
    @JsonProperty("RegionTitle")
    private String regionTitle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("RegionId")
    public Integer getRegionId() {
        return regionId;
    }

    @JsonProperty("RegionId")
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @JsonProperty("CountryId")
    public Integer getCountryId() {
        return countryId;
    }

    @JsonProperty("CountryId")
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("RegionTitle")
    public String getRegionTitle() {
        return regionTitle;
    }

    @JsonProperty("RegionTitle")
    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(regionId, address.regionId) && Objects.equals(countryId, address.countryId) && Objects.equals(regionTitle, address.regionTitle) && Objects.equals(additionalProperties, address.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, countryId, regionTitle, additionalProperties);
    }

    @Override
    public String toString() {
        return "Address{" +
                "regionId=" + regionId +
                ", countryId=" + countryId +
                ", regionTitle='" + regionTitle + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
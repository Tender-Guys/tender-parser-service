package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalCount",
        "TotalCountInAnotherSegment",
        "TendersCount",
        "Tenders",
        "SearchType",
        "IsSubscribed",
        "ShowIdentificationMessage"
})
public class SmarttenderDTO {
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("TotalCountInAnotherSegment")
    private Integer totalCountInAnotherSegment;
    @JsonProperty("TendersCount")
    private Integer tendersCount;
    @JsonProperty("Tenders")
    private List<Tender> tenders;
    @JsonProperty("SearchType")
    private Integer searchType;
    @JsonProperty("IsSubscribed")
    private Boolean isSubscribed;
    @JsonProperty("ShowIdentificationMessage")
    private Boolean showIdentificationMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("TotalCountInAnotherSegment")
    public Integer getTotalCountInAnotherSegment() {
        return totalCountInAnotherSegment;
    }

    @JsonProperty("TotalCountInAnotherSegment")
    public void setTotalCountInAnotherSegment(Integer totalCountInAnotherSegment) {
        this.totalCountInAnotherSegment = totalCountInAnotherSegment;
    }

    @JsonProperty("TendersCount")
    public Integer getTendersCount() {
        return tendersCount;
    }

    @JsonProperty("TendersCount")
    public void setTendersCount(Integer tendersCount) {
        this.tendersCount = tendersCount;
    }

    @JsonProperty("Tenders")
    public List<Tender> getTenders() {
        return tenders;
    }

    @JsonProperty("Tenders")
    public void setTenders(List<Tender> tenders) {
        this.tenders = tenders;
    }

    @JsonProperty("SearchType")
    public Integer getSearchType() {
        return searchType;
    }

    @JsonProperty("SearchType")
    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    @JsonProperty("IsSubscribed")
    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    @JsonProperty("IsSubscribed")
    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    @JsonProperty("ShowIdentificationMessage")
    public Boolean getShowIdentificationMessage() {
        return showIdentificationMessage;
    }

    @JsonProperty("ShowIdentificationMessage")
    public void setShowIdentificationMessage(Boolean showIdentificationMessage) {
        this.showIdentificationMessage = showIdentificationMessage;
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
        if (!(o instanceof SmarttenderDTO that)) return false;
        return Objects.equals(totalCount, that.totalCount) && Objects.equals(totalCountInAnotherSegment, that.totalCountInAnotherSegment) && Objects.equals(tendersCount, that.tendersCount) && Objects.equals(tenders, that.tenders) && Objects.equals(searchType, that.searchType) && Objects.equals(isSubscribed, that.isSubscribed) && Objects.equals(showIdentificationMessage, that.showIdentificationMessage) && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, totalCountInAnotherSegment, tendersCount, tenders, searchType, isSubscribed, showIdentificationMessage, additionalProperties);
    }

    @Override
    public String toString() {
        return "SmarttenderDTO{" +
                "totalCount=" + totalCount +
                ", totalCountInAnotherSegment=" + totalCountInAnotherSegment +
                ", tendersCount=" + tendersCount +
                ", tenders=" + tenders +
                ", searchType=" + searchType +
                ", isSubscribed=" + isSubscribed +
                ", showIdentificationMessage=" + showIdentificationMessage +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TenderDTO {

    private Integer totalCount;
    private Integer totalCountInAnotherSegment;
    private Integer tendersCount;
    private List<Tender> tenders;
    private Integer searchType;
    private Boolean isSubscribed;
    private Boolean showIdentificationMessage;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalCountInAnotherSegment() {
        return totalCountInAnotherSegment;
    }

    public void setTotalCountInAnotherSegment(Integer totalCountInAnotherSegment) {
        this.totalCountInAnotherSegment = totalCountInAnotherSegment;
    }

    public Integer getTendersCount() {
        return tendersCount;
    }

    public void setTendersCount(Integer tendersCount) {
        this.tendersCount = tendersCount;
    }

    public List<Tender> getTenders() {
        return tenders;
    }

    public void setTenders(List<Tender> tenders) {
        this.tenders = tenders;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public Boolean getShowIdentificationMessage() {
        return showIdentificationMessage;
    }

    public void setShowIdentificationMessage(Boolean showIdentificationMessage) {
        this.showIdentificationMessage = showIdentificationMessage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}



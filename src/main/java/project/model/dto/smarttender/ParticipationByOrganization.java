package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StatusByOrganization",
        "IsInvalidBid",
        "NotesType",
        "UserRemark",
        "StatusByUser",
        "AssignedByTender",
        "IsFavorite"
})
public class ParticipationByOrganization {
    @JsonProperty("StatusByOrganization")
    private Integer statusByOrganization;
    @JsonProperty("IsInvalidBid")
    private Boolean isInvalidBid;
    @JsonProperty("NotesType")
    private Integer notesType;
    @JsonProperty("UserRemark")
    private String userRemark;
    @JsonProperty("StatusByUser")
    private Integer statusByUser;
    @JsonProperty("AssignedByTender")
    private AssignedByTender assignedByTender;
    @JsonProperty("IsFavorite")
    private Boolean isFavorite;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("StatusByOrganization")
    public Integer getStatusByOrganization() {
        return statusByOrganization;
    }

    @JsonProperty("StatusByOrganization")
    public void setStatusByOrganization(Integer statusByOrganization) {
        this.statusByOrganization = statusByOrganization;
    }

    @JsonProperty("IsInvalidBid")
    public Boolean getIsInvalidBid() {
        return isInvalidBid;
    }

    @JsonProperty("IsInvalidBid")
    public void setIsInvalidBid(Boolean isInvalidBid) {
        this.isInvalidBid = isInvalidBid;
    }

    @JsonProperty("NotesType")
    public Integer getNotesType() {
        return notesType;
    }

    @JsonProperty("NotesType")
    public void setNotesType(Integer notesType) {
        this.notesType = notesType;
    }

    @JsonProperty("UserRemark")
    public String getUserRemark() {
        return userRemark;
    }

    @JsonProperty("UserRemark")
    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    @JsonProperty("StatusByUser")
    public Integer getStatusByUser() {
        return statusByUser;
    }

    @JsonProperty("StatusByUser")
    public void setStatusByUser(Integer statusByUser) {
        this.statusByUser = statusByUser;
    }

    @JsonProperty("AssignedByTender")
    public AssignedByTender getAssignedByTender() {
        return assignedByTender;
    }

    @JsonProperty("AssignedByTender")
    public void setAssignedByTender(AssignedByTender assignedByTender) {
        this.assignedByTender = assignedByTender;
    }

    @JsonProperty("IsFavorite")
    public Boolean getIsFavorite() {
        return isFavorite;
    }

    @JsonProperty("IsFavorite")
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
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
        return "ParticipationByOrganization{" +
                "statusByOrganization=" + statusByOrganization +
                ", isInvalidBid=" + isInvalidBid +
                ", notesType=" + notesType +
                ", userRemark='" + userRemark + '\'' +
                ", statusByUser=" + statusByUser +
                ", assignedByTender=" + assignedByTender +
                ", isFavorite=" + isFavorite +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
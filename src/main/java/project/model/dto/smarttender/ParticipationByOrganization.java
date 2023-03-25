package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParticipationByOrganization {

    private Integer statusByOrganization;
    private Boolean isInvalidBid;
    private Integer notesType;
    private String userRemark;
    private Integer statusByUser;
    private AssignedByTender assignedByTender;
    private Boolean isFavorite;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getStatusByOrganization() {
        return statusByOrganization;
    }

    public void setStatusByOrganization(Integer statusByOrganization) {
        this.statusByOrganization = statusByOrganization;
    }

    public Boolean getIsInvalidBid() {
        return isInvalidBid;
    }

    public void setIsInvalidBid(Boolean isInvalidBid) {
        this.isInvalidBid = isInvalidBid;
    }

    public Integer getNotesType() {
        return notesType;
    }

    public void setNotesType(Integer notesType) {
        this.notesType = notesType;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public Integer getStatusByUser() {
        return statusByUser;
    }

    public void setStatusByUser(Integer statusByUser) {
        this.statusByUser = statusByUser;
    }

    public AssignedByTender getAssignedByTender() {
        return assignedByTender;
    }

    public void setAssignedByTender(AssignedByTender assignedByTender) {
        this.assignedByTender = assignedByTender;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class AssignedByTender {

    private Integer userId;
    private String colorClass;
    private String assignedTitle;
    private Boolean isRejected;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getColorClass() {
        return colorClass;
    }

    public void setColorClass(String colorClass) {
        this.colorClass = colorClass;
    }

    public String getAssignedTitle() {
        return assignedTitle;
    }

    public void setAssignedTitle(String assignedTitle) {
        this.assignedTitle = assignedTitle;
    }

    public Boolean getIsRejected() {
        return isRejected;
    }

    public void setIsRejected(Boolean isRejected) {
        this.isRejected = isRejected;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

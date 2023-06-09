package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UserId",
        "ColorClass",
        "AssignedTitle",
        "IsRejected"
})
public class AssignedByTender {
    @JsonProperty("UserId")
    private Integer userId;
    @JsonProperty("ColorClass")
    private String colorClass;
    @JsonProperty("AssignedTitle")
    private String assignedTitle;
    @JsonProperty("IsRejected")
    private Boolean isRejected;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("UserId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("UserId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("ColorClass")
    public String getColorClass() {
        return colorClass;
    }

    @JsonProperty("ColorClass")
    public void setColorClass(String colorClass) {
        this.colorClass = colorClass;
    }

    @JsonProperty("AssignedTitle")
    public String getAssignedTitle() {
        return assignedTitle;
    }

    @JsonProperty("AssignedTitle")
    public void setAssignedTitle(String assignedTitle) {
        this.assignedTitle = assignedTitle;
    }

    @JsonProperty("IsRejected")
    public Boolean getIsRejected() {
        return isRejected;
    }

    @JsonProperty("IsRejected")
    public void setIsRejected(Boolean isRejected) {
        this.isRejected = isRejected;
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
        if (!(o instanceof AssignedByTender that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(colorClass, that.colorClass) && Objects.equals(assignedTitle, that.assignedTitle) && Objects.equals(isRejected, that.isRejected) && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, colorClass, assignedTitle, isRejected, additionalProperties);
    }

    @Override
    public String toString() {
        return "AssignedByTender{" +
                "userId=" + userId +
                ", colorClass='" + colorClass + '\'' +
                ", assignedTitle='" + assignedTitle + '\'' +
                ", isRejected=" + isRejected +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
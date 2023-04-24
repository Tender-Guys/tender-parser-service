package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Status",
        "Title",
        "Color"
})
public class StatusInfo {
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Color")
    private String color;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Color")
    public String getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(String color) {
        this.color = color;
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
        return "StatusInfo{" +
                "status=" + status +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
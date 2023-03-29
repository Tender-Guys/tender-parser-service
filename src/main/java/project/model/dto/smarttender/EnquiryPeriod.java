package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DateStart",
        "DateStartTitle",
        "DateEnd"
})
public class EnquiryPeriod {

    @JsonProperty("DateStart")
    private String dateStart;
    @JsonProperty("DateStartTitle")
    private String dateStartTitle;
    @JsonProperty("DateEnd")
    private String dateEnd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("DateStart")
    public String getDateStart() {
        return dateStart;
    }

    @JsonProperty("DateStart")
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @JsonProperty("DateStartTitle")
    public String getDateStartTitle() {
        return dateStartTitle;
    }

    @JsonProperty("DateStartTitle")
    public void setDateStartTitle(String dateStartTitle) {
        this.dateStartTitle = dateStartTitle;
    }

    @JsonProperty("DateEnd")
    public String getDateEnd() {
        return dateEnd;
    }

    @JsonProperty("DateEnd")
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
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
        return "EnquiryPeriod{" +
                "dateStart='" + dateStart + '\'' +
                ", dateStartTitle='" + dateStartTitle + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

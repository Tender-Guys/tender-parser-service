package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DateStart",
        "DateStartTitle",
        "DateEnd",
        "DateEndTitle"
})
public class TenderingPeriod {

    @JsonProperty("DateStart")
    private String dateStart;
    @JsonProperty("DateStartTitle")
    private String dateStartTitle;
    @JsonProperty("DateEnd")
    private String dateEnd;
    @JsonProperty("DateEndTitle")
    private String dateEndTitle;
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

    @JsonProperty("DateEndTitle")
    public String getDateEndTitle() {
        return dateEndTitle;
    }

    @JsonProperty("DateEndTitle")
    public void setDateEndTitle(String dateEndTitle) {
        this.dateEndTitle = dateEndTitle;
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
        return "TenderingPeriod{" +
                "dateStart='" + dateStart + '\'' +
                ", dateStartTitle='" + dateStartTitle + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", dateEndTitle='" + dateEndTitle + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}


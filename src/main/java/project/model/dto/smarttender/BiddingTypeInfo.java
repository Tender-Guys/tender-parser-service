package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class BiddingTypeInfo {

    private Integer id;
    private String title;
    private String description;
    private Integer tradeSegment;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTradeSegment() {
        return tradeSegment;
    }

    public void setTradeSegment(Integer tradeSegment) {
        this.tradeSegment = tradeSegment;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

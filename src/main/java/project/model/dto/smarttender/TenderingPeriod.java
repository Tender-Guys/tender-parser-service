package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class TenderingPeriod {

    private String dateStart;
    private String dateStartTitle;
    private String dateEnd;
    private String dateEndTitle;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateStartTitle() {
        return dateStartTitle;
    }

    public void setDateStartTitle(String dateStartTitle) {
        this.dateStartTitle = dateStartTitle;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateEndTitle() {
        return dateEndTitle;
    }

    public void setDateEndTitle(String dateEndTitle) {
        this.dateEndTitle = dateEndTitle;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

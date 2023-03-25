package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnquiryPeriod {

    private String dateStart;
    private String dateStartTitle;
    private String dateEnd;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

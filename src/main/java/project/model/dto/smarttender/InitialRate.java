package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.Map;

public class InitialRate {

    private Double amount;
    private String amountTitle;
    private Boolean withVat;
    private String vatTitle;
    private String currencyTitle;
    private String currencyHtmlTitle;
    private Integer currencyId;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountTitle() {
        return amountTitle;
    }

    public void setAmountTitle(String amountTitle) {
        this.amountTitle = amountTitle;
    }

    public Boolean getWithVat() {
        return withVat;
    }

    public void setWithVat(Boolean withVat) {
        this.withVat = withVat;
    }

    public String getVatTitle() {
        return vatTitle;
    }

    public void setVatTitle(String vatTitle) {
        this.vatTitle = vatTitle;
    }

    public String getCurrencyTitle() {
        return currencyTitle;
    }

    public void setCurrencyTitle(String currencyTitle) {
        this.currencyTitle = currencyTitle;
    }

    public String getCurrencyHtmlTitle() {
        return currencyHtmlTitle;
    }

    public void setCurrencyHtmlTitle(String currencyHtmlTitle) {
        this.currencyHtmlTitle = currencyHtmlTitle;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

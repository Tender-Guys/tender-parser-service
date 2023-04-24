package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Amount",
        "AmountTitle",
        "WithVat",
        "VatTitle",
        "CurrencyTitle",
        "CurrencyHtmlTitle",
        "CurrencyId"
})
public class InitialRate {
    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("AmountTitle")
    private String amountTitle;
    @JsonProperty("WithVat")
    private Boolean withVat;
    @JsonProperty("VatTitle")
    private String vatTitle;
    @JsonProperty("CurrencyTitle")
    private String currencyTitle;
    @JsonProperty("CurrencyHtmlTitle")
    private String currencyHtmlTitle;
    @JsonProperty("CurrencyId")
    private Integer currencyId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("Amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("AmountTitle")
    public String getAmountTitle() {
        return amountTitle;
    }

    @JsonProperty("AmountTitle")
    public void setAmountTitle(String amountTitle) {
        this.amountTitle = amountTitle;
    }

    @JsonProperty("WithVat")
    public Boolean getWithVat() {
        return withVat;
    }

    @JsonProperty("WithVat")
    public void setWithVat(Boolean withVat) {
        this.withVat = withVat;
    }

    @JsonProperty("VatTitle")
    public String getVatTitle() {
        return vatTitle;
    }

    @JsonProperty("VatTitle")
    public void setVatTitle(String vatTitle) {
        this.vatTitle = vatTitle;
    }

    @JsonProperty("CurrencyTitle")
    public String getCurrencyTitle() {
        return currencyTitle;
    }

    @JsonProperty("CurrencyTitle")
    public void setCurrencyTitle(String currencyTitle) {
        this.currencyTitle = currencyTitle;
    }

    @JsonProperty("CurrencyHtmlTitle")
    public String getCurrencyHtmlTitle() {
        return currencyHtmlTitle;
    }

    @JsonProperty("CurrencyHtmlTitle")
    public void setCurrencyHtmlTitle(String currencyHtmlTitle) {
        this.currencyHtmlTitle = currencyHtmlTitle;
    }

    @JsonProperty("CurrencyId")
    public Integer getCurrencyId() {
        return currencyId;
    }

    @JsonProperty("CurrencyId")
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
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
        return "InitialRate{" +
                "amount=" + amount +
                ", amountTitle='" + amountTitle + '\'' +
                ", withVat=" + withVat +
                ", vatTitle='" + vatTitle + '\'' +
                ", currencyTitle='" + currencyTitle + '\'' +
                ", currencyHtmlTitle='" + currencyHtmlTitle + '\'' +
                ", currencyId=" + currencyId +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
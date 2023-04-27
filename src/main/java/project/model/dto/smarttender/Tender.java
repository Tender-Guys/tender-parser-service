package project.model.dto.smarttender;

import com.fasterxml.jackson.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Number",
        "Subject",
        "TenderStatus",
        "InitialRate",
        "Organizer",
        "Classification",
        "TenderingPeriod",
        "EnquiryPeriod",
        "TerminalStatusDate",
        "AuctionStart",
        "BiddingTypeInfo",
        "StatusInfo",
        "IsLocked",
        "ViewCount",
        "ParticipationByOrganization",
        "Highlights",
        "FileElasticHighlights",
        "Prediction",
        "TenderingForPercentage"
})
public class Tender {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Number")
    private String number;
    @JsonProperty("Subject")
    private String subject;
    @JsonProperty("TenderStatus")
    private Integer tenderStatus;
    @JsonProperty("InitialRate")
    private InitialRate initialRate;
    @JsonProperty("Organizer")
    private Organizer organizer;
    @JsonProperty("Classification")
    private Classification classification;
    @JsonProperty("TenderingPeriod")
    private TenderingPeriod tenderingPeriod;
    @JsonProperty("EnquiryPeriod")
    private EnquiryPeriod enquiryPeriod;
    @JsonProperty("TerminalStatusDate")
    private String terminalStatusDate;
    @JsonProperty("AuctionStart")
    private String auctionStart;
    @JsonProperty("BiddingTypeInfo")
    private BiddingTypeInfo biddingTypeInfo;
    @JsonProperty("StatusInfo")
    private StatusInfo statusInfo;
    @JsonProperty("IsLocked")
    private Boolean isLocked;
    @JsonProperty("ViewCount")
    private Integer viewCount;
    @JsonProperty("ParticipationByOrganization")
    private ParticipationByOrganization participationByOrganization;
    @JsonProperty("Highlights")
    private List<Object> highlights;
    @JsonProperty("FileElasticHighlights")
    private List<Object> fileElasticHighlights;
    @JsonProperty("Prediction")
    private Double prediction;
    @JsonProperty("TenderingForPercentage")
    private Boolean tenderingForPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("Number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("Subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("Subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("TenderStatus")
    public Integer getTenderStatus() {
        return tenderStatus;
    }

    @JsonProperty("TenderStatus")
    public void setTenderStatus(Integer tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    @JsonProperty("InitialRate")
    public InitialRate getInitialRate() {
        return initialRate;
    }

    @JsonProperty("InitialRate")
    public void setInitialRate(InitialRate initialRate) {
        this.initialRate = initialRate;
    }

    @JsonProperty("Organizer")
    public Organizer getOrganizer() {
        return organizer;
    }

    @JsonProperty("Organizer")
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @JsonProperty("Classification")
    public Classification getClassification() {
        return classification;
    }

    @JsonProperty("Classification")
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @JsonProperty("TenderingPeriod")
    public TenderingPeriod getTenderingPeriod() {
        return tenderingPeriod;
    }

    @JsonProperty("TenderingPeriod")
    public void setTenderingPeriod(TenderingPeriod tenderingPeriod) {
        this.tenderingPeriod = tenderingPeriod;
    }

    @JsonProperty("EnquiryPeriod")
    public EnquiryPeriod getEnquiryPeriod() {
        return enquiryPeriod;
    }

    @JsonProperty("EnquiryPeriod")
    public void setEnquiryPeriod(EnquiryPeriod enquiryPeriod) {
        this.enquiryPeriod = enquiryPeriod;
    }

    @JsonProperty("TerminalStatusDate")
    public String getTerminalStatusDate() {
        return terminalStatusDate;
    }

    @JsonProperty("TerminalStatusDate")
    public void setTerminalStatusDate(String terminalStatusDate) {
        this.terminalStatusDate = terminalStatusDate;
    }

    @JsonProperty("AuctionStart")
    public String getAuctionStart() {
        return auctionStart;
    }

    @JsonProperty("AuctionStart")
    public void setAuctionStart(String auctionStart) {
        this.auctionStart = auctionStart;
    }

    @JsonProperty("BiddingTypeInfo")
    public BiddingTypeInfo getBiddingTypeInfo() {
        return biddingTypeInfo;
    }

    @JsonProperty("BiddingTypeInfo")
    public void setBiddingTypeInfo(BiddingTypeInfo biddingTypeInfo) {
        this.biddingTypeInfo = biddingTypeInfo;
    }

    @JsonProperty("StatusInfo")
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    @JsonProperty("StatusInfo")
    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    @JsonProperty("IsLocked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("IsLocked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("ViewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("ViewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("ParticipationByOrganization")
    public ParticipationByOrganization getParticipationByOrganization() {
        return participationByOrganization;
    }

    @JsonProperty("ParticipationByOrganization")
    public void setParticipationByOrganization(ParticipationByOrganization participationByOrganization) {
        this.participationByOrganization = participationByOrganization;
    }

    @JsonProperty("Highlights")
    public List<Object> getHighlights() {
        return highlights;
    }

    @JsonProperty("Highlights")
    public void setHighlights(List<Object> highlights) {
        this.highlights = highlights;
    }

    @JsonProperty("FileElasticHighlights")
    public List<Object> getFileElasticHighlights() {
        return fileElasticHighlights;
    }

    @JsonProperty("FileElasticHighlights")
    public void setFileElasticHighlights(List<Object> fileElasticHighlights) {
        this.fileElasticHighlights = fileElasticHighlights;
    }

    @JsonProperty("Prediction")
    public Double getPrediction() {
        return prediction;
    }

    @JsonProperty("Prediction")
    public void setPrediction(Double prediction) {
        this.prediction = prediction;
    }

    @JsonProperty("TenderingForPercentage")
    public Boolean getTenderingForPercentage() {
        return tenderingForPercentage;
    }

    @JsonProperty("TenderingForPercentage")
    public void setTenderingForPercentage(Boolean tenderingForPercentage) {
        this.tenderingForPercentage = tenderingForPercentage;
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
        if (!(o instanceof Tender tender)) return false;

        if (!id.equals(tender.id)) return false;
        if (!number.equals(tender.number)) return false;
        if (!subject.equals(tender.subject)) return false;
        if (!tenderStatus.equals(tender.tenderStatus)) return false;
        if (!organizer.equals(tender.organizer)) return false;
        return classification.equals(tender.classification);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + tenderStatus.hashCode();
        result = 31 * result + organizer.hashCode();
        result = 31 * result + classification.hashCode();
        return result;
    }
}
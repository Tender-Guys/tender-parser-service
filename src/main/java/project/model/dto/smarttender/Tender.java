package project.model.dto.smarttender;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tender {

    private Integer id;
    private String number;
    private String subject;
    private Integer tenderStatus;
    private InitialRate initialRate;
    private Organizer organizer;
    private Classification classification;
    private TenderingPeriod tenderingPeriod;
    private EnquiryPeriod enquiryPeriod;
    private String terminalStatusDate;
    private String auctionStart;
    private String statusDateEndTitle;
    private String statusTimeLeftTitle;
    private BiddingTypeInfo biddingTypeInfo;
    private StatusInfo statusInfo;
    private Boolean isLocked;
    private Integer viewCount;
    private ParticipationByOrganization participationByOrganization;
    private List<Object> highlights;
    private List<Object> fileElasticHighlights;
    private Double prediction;
    private Boolean tenderingForPercentage;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTenderStatus() {
        return tenderStatus;
    }

    public void setTenderStatus(Integer tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    public InitialRate getInitialRate() {
        return initialRate;
    }

    public void setInitialRate(InitialRate initialRate) {
        this.initialRate = initialRate;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public TenderingPeriod getTenderingPeriod() {
        return tenderingPeriod;
    }

    public void setTenderingPeriod(TenderingPeriod tenderingPeriod) {
        this.tenderingPeriod = tenderingPeriod;
    }

    public EnquiryPeriod getEnquiryPeriod() {
        return enquiryPeriod;
    }

    public void setEnquiryPeriod(EnquiryPeriod enquiryPeriod) {
        this.enquiryPeriod = enquiryPeriod;
    }

    public String getTerminalStatusDate() {
        return terminalStatusDate;
    }

    public void setTerminalStatusDate(String terminalStatusDate) {
        this.terminalStatusDate = terminalStatusDate;
    }

    public String getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(String auctionStart) {
        this.auctionStart = auctionStart;
    }

    public String getStatusDateEndTitle() {
        return statusDateEndTitle;
    }

    public void setStatusDateEndTitle(String statusDateEndTitle) {
        this.statusDateEndTitle = statusDateEndTitle;
    }

    public String getStatusTimeLeftTitle() {
        return statusTimeLeftTitle;
    }

    public void setStatusTimeLeftTitle(String statusTimeLeftTitle) {
        this.statusTimeLeftTitle = statusTimeLeftTitle;
    }

    public BiddingTypeInfo getBiddingTypeInfo() {
        return biddingTypeInfo;
    }

    public void setBiddingTypeInfo(BiddingTypeInfo biddingTypeInfo) {
        this.biddingTypeInfo = biddingTypeInfo;
    }

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public ParticipationByOrganization getParticipationByOrganization() {
        return participationByOrganization;
    }

    public void setParticipationByOrganization(ParticipationByOrganization participationByOrganization) {
        this.participationByOrganization = participationByOrganization;
    }

    public List<Object> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Object> highlights) {
        this.highlights = highlights;
    }

    public List<Object> getFileElasticHighlights() {
        return fileElasticHighlights;
    }

    public void setFileElasticHighlights(List<Object> fileElasticHighlights) {
        this.fileElasticHighlights = fileElasticHighlights;
    }

    public Double getPrediction() {
        return prediction;
    }

    public void setPrediction(Double prediction) {
        this.prediction = prediction;
    }

    public Boolean getTenderingForPercentage() {
        return tenderingForPercentage;
    }

    public void setTenderingForPercentage(Boolean tenderingForPercentage) {
        this.tenderingForPercentage = tenderingForPercentage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

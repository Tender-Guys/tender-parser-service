package project.model.response;

import java.sql.Timestamp;

public class Tender {
    private int id;
    private Site site;
    private String siteInnerId;
    private Initiator initiator;
    private String subject;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;
    private String url;

    public Tender() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getSiteInnerId() {
        return siteInnerId;
    }

    public void setSiteInnerId(String siteInnerId) {
        this.siteInnerId = siteInnerId;
    }

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Timestamp endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // add HashCode and Equals
    // add Comparable interface
}


package project.model.response;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(schema = "tendersdb", name = "tenders")
public class Tender {
    @Id
    @Column(name = "tender_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tender_site_id")
    private Site site;

    @Column(name = "tender_site_inner_id")
    private String siteInnerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tender_initiator_id")
    private Initiator initiator;

    @Column(name = "tender_subject")
    private String subject;

    @Column(name = "tender_start_time")
    private Timestamp startTimestamp;

    @Column(name = "tender_end_time")
    private Timestamp endTimestamp;

    @Column(name = "tender_url")
    private String url;

    public Tender() {
        //Empty constructor
    }

    public Tender(Integer id,
                  Site site,
                  String siteInnerId,
                  Initiator initiator,
                  String subject,
                  Timestamp startTimestamp,
                  Timestamp endTimestamp,
                  String url) {
        this.id = id;
        this.site = site;
        this.siteInnerId = siteInnerId;
        this.initiator = initiator;
        this.subject = subject;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tender)) return false;
        Tender tender = (Tender) o;
        return Objects.equals(id, tender.id) && Objects.equals(site, tender.site) && Objects.equals(siteInnerId, tender.siteInnerId) && Objects.equals(initiator, tender.initiator) && Objects.equals(subject, tender.subject) && Objects.equals(startTimestamp, tender.startTimestamp) && Objects.equals(endTimestamp, tender.endTimestamp) && Objects.equals(url, tender.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, site, siteInnerId, initiator, subject, startTimestamp, endTimestamp, url);
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id=" + id +
                ", site=" + site +
                ", siteInnerId='" + siteInnerId + '\'' +
                ", initiator=" + initiator +
                ", subject='" + subject + '\'' +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", url='" + url + '\'' +
                '}';
    }
}


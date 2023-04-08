package project.model.response;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "tendersdb", name = "tender_sites")
public class Site {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "tender_site_id")
    private Integer id;

    @Column(name = "tender_site_name")
    private String name;

    @Column(name = "tender_site_home_url")
    private String url;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tender> tenders = new HashSet<>();

    public Site() {
        //Empty constructor
    }

    public Site(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String url;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Site build() {
            return new Site(id, name, url);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Site)) return false;
        Site site = (Site) o;
        return Objects.equals(id, site.id) && Objects.equals(name, site.name) && Objects.equals(url, site.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}



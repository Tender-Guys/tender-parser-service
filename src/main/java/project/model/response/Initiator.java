package project.model.response;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "tendersdb", name = "tender_initiators")
public class Initiator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tender_initiator_id")
    private Integer id;

    @Column(name = "tender_initiator_name")
    private String name;

    @Column(name = "tender_initiator_contact_name")
    private String contactName;

    @Column(name = "tender_initiator_contact_phone")
    private String contactPhone;

    @OneToMany(mappedBy = "initiator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tender> tenders = new HashSet<>();

    public Initiator() {
        //Empty constructor
    }

    public Initiator(Integer id, String name, String contactName, String contactPhone) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String contactName;
        private String contactPhone;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withContactName(String contactName) {
            this.contactName = contactName;
            return this;
        }

        public Builder withContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public Initiator build() {
            return new Initiator(id, name, contactName, contactPhone);
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Initiator)) return false;
        Initiator initiator = (Initiator) o;
        return Objects.equals(id, initiator.id) && Objects.equals(name, initiator.name) && Objects.equals(contactName, initiator.contactName) && Objects.equals(contactPhone, initiator.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactName, contactPhone);
    }

    @Override
    public String toString() {
        return "Initiator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}

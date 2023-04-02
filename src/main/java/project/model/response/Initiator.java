package project.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(schema = "tendersdb", name = "tender_initiators")
public class Initiator {
    @Id
    private Integer id;

    @Column(name = "tender_initiator_name")
    private String name;

    @Column(name = "tender_initiator_contact_name")
    private String contactName;

    @Column(name = "tender_initiator_contact_phone")
    private String contactPhone;

    public Initiator() {
        //Empty constructor
    }

    public Initiator(Integer id, String name, String contactName, String contactPhone) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
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

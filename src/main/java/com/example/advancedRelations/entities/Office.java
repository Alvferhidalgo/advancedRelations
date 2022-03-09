package com.example.advancedRelations.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "office")
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="office_id")
    private String officeId;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Customer> customers;

    public Office() {
    }

    public Office(Long id, String officeId, Address address, List<Customer> customers) {
        this.id = id;
        this.officeId = officeId;
        this.address = address;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", officeId='" + officeId + '\'' +
                '}';
    }
}

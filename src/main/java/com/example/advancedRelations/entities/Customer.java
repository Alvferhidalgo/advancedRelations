package com.example.advancedRelations.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nif")
    private String nif;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_address", foreignKey = @ForeignKey(name = "fk_customer_address"))
    private Address address;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(Long id, String name, String nif, Address address, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}

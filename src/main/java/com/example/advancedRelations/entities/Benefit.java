package com.example.advancedRelations.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Benefit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agent;

    private Double credit;

    private Boolean loan;

    public Benefit() {
    }

    public Benefit(Long id, String agent, Double credit, Boolean loan) {
        this.id = id;
        this.agent = agent;
        this.credit = credit;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Boolean getLoan() {
        return loan;
    }

    public void setLoan(Boolean loan) {
        this.loan = loan;
    }
}

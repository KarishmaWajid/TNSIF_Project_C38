package com.tnsif.pm_service;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class College {
    
    
    private Long id;
    private String name;
    private String address;
    private String accreditation;
    private LocalDate establishedDate;

    
    // Constructors, Getters, and Setters

    public College() {}

    public College(Long id, String name, String address, String accreditation, LocalDate establishedDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accreditation = accreditation;
        this.establishedDate = establishedDate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }
}
package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pigCode;
    @Column(columnDefinition = "Date")
    private String importDay;
    private String importWeight;
    @Column(columnDefinition = "Date")
    private String exportDay;
    private String exportWeight;
    private int status;
    @ManyToOne
    @JoinColumn(name="countryId",referencedColumnName = "id")
    private Country country;

    public Pig() {
    }

    public Pig(String pigCode, String importDay, String importWeight, String exportDay, String exportWeight, int status, Country country) {
        this.pigCode = pigCode;
        this.importDay = importDay;
        this.importWeight = importWeight;
        this.exportDay = exportDay;
        this.exportWeight = exportWeight;
        this.status = status;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPigCode() {
        return pigCode;
    }

    public void setPigCode(String pigCode) {
        this.pigCode = pigCode;
    }

    public String getImportDay() {
        return importDay;
    }

    public void setImportDay(String importDay) {
        this.importDay = importDay;
    }

    public String getImportWeight() {
        return importWeight;
    }

    public void setImportWeight(String importWeight) {
        this.importWeight = importWeight;
    }

    public String getExportDay() {
        return exportDay;
    }

    public void setExportDay(String exportDay) {
        this.exportDay = exportDay;
    }

    public String getExportWeight() {
        return exportWeight;
    }

    public void setExportWeight(String exportWeight) {
        this.exportWeight = exportWeight;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

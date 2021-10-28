package com.codegym.model;

import java.util.List;

public class Address {
    private List<String> country;
    private List<String> district;
    private List<String> ward;
    private String street;

    public Address() {
    }

    public Address(List<String> country, List<String> district, List<String> ward, String street) {
        this.country = country;
        this.district = district;
        this.ward = ward;
        this.street = street;
    }



    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getDistrict() {
        return district;
    }

    public void setDistrict(List<String> district) {
        this.district = district;
    }

    public List<String> getWard() {
        return ward;
    }

    public void setWard(List<String> ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

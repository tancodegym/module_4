package com.codegym.model;

public class Person {
    private String name;
    private int yearOfBirth;
    private int gender;
    private String nationality;
    private String idCard;
    private int vehicle;
    private String vehicleName;
    private String seat;
    private StartDate startDate;
    private EndDate endDate;
    private String city;
    private Address address;
    private String phone;
    private String email;
    private boolean[] symptom;
    private boolean[] history;

    public Person() {
    }

    public Person(String name, int yearOfBirth, int gender, String nationality, String idCard,
                  int vehicle, String vehicleName, String seat, StartDate startDate, EndDate endDate, String city, Address address, String phone, String email, boolean[] symptom, boolean[] history) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleName = vehicleName;
        this.seat = seat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate endDate) {
        this.endDate = endDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean[] getSymptom() {
        return symptom;
    }

    public void setSymptom(boolean[] symptom) {
        this.symptom = symptom;
    }

    public boolean[] getHistory() {
        return history;
    }

    public void setHistory(boolean[] history) {
        this.history = history;
    }
}

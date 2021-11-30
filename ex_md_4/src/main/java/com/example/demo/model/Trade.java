package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(columnDefinition = "Date")
    private String day;
    private int type;
    private int price;
    private int area;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer customer;

    public Trade() {
    }

    public Trade(String code, String day, int type, int price, int area, Customer customer) {
        this.code = code;
        this.day = day;
        this.type = type;
        this.price = price;
        this.area = area;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

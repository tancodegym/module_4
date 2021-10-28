package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String decription;
    private String producer;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int id, String name, double price, String decription, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decription = decription;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

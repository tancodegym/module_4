package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 1000)
    private String head;
    @Column(length = 5000)
    private String body;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    private Date date;

    public Blog(String title, String head, String body, Category category) {
        this.title = title;
        this.head = head;
        this.body = body;
        this.category = category;
    }

    public Blog(String title, String head, String body, Category category, Date date) {
        this.title = title;
        this.head = head;
        this.body = body;
        this.category = category;
        this.date = date;
    }

    public Blog() {
    }

    public Blog(String title, String head, String body) {
        this.title = title;
        this.head = head;
        this.body = body;
    }

    public Blog(int id, String title, String head, String body) {
        this.id = id;
        this.title = title;
        this.head = head;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package com.codegym.cms.model;

import javax.persistence.*;

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
}

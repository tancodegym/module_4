package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String singger;
    private String kindOfMusics;
    private String path;

    public Song() {
    }

    public Song(String name, String singger, String kindOfMusics, String path) {
        this.name = name;
        this.singger = singger;
        this.kindOfMusics = kindOfMusics;
        this.path = path;
    }

    public Song(int id, String name, String singger, String kindOfMusics, String path) {
        this.id = id;
        this.name = name;
        this.singger = singger;
        this.kindOfMusics = kindOfMusics;
        this.path = path;
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

    public String getSingger() {
        return singger;
    }

    public void setSingger(String singger) {
        this.singger = singger;
    }

    public String getKindOfMusics() {
        return kindOfMusics;
    }

    public void setKindOfMusics(String kindOfMusics) {
        this.kindOfMusics = kindOfMusics;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


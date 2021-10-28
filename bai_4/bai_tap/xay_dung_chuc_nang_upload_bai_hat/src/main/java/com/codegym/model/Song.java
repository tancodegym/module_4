package com.codegym.model;

public class Song {
    private String name;
    private String singger;
    private String[] kindOfMusics;
    private String path;

    public Song() {
    }

    public Song(String name, String singger, String[] kindOfMusics, String path) {
        this.name = name;
        this.singger = singger;
        this.kindOfMusics = kindOfMusics;
        this.path = path;
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

    public String[] getKindOfMusics() {
        return kindOfMusics;
    }

    public void setKindOfMusics(String[] kindOfMusics) {
        this.kindOfMusics = kindOfMusics;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private String name;
    private String singger;
    private String[] kindOfMusics;
    private String path;
    private MultipartFile song;

    public SongForm() {
    }

    public SongForm(String name, String singger, String[] kindOfMusics, String path, MultipartFile song) {
        this.name = name;
        this.singger = singger;
        this.kindOfMusics = kindOfMusics;
        this.path = path;
        this.song = song;
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

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }
}

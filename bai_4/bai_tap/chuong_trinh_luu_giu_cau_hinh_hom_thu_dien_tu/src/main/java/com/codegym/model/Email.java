package com.codegym.model;

public class Email {
    private String[] languages;
    private int[] pageSize;
    int spamsFilter;
    private String signature;

    public Email() {
    }

    public Email(String[] languages, int[] pageSize, int spamsFilter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public int[] getPageSize() {
        return pageSize;
    }

    public void setPageSize(int[] pageSize) {
        this.pageSize = pageSize;
    }

    public int getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(int spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

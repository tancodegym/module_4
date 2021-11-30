package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Pig> pigList;

    public Country() {
    }

    public Country(String name, List<Pig> pigList) {
        this.name = name;
        this.pigList = pigList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }
}

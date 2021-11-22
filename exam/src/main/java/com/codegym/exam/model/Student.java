package com.codegym.exam.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private int age;
    private int mark;
    private String address;
    private String phone;
    private String email;
    private int gender;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "className_id",referencedColumnName = "id")
    private ClassName className;

    public Student() {
    }

    public Student(String code, String name, int age, int mark, String address, String phone, String email, int gender, ClassName className) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.mark = mark;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.className = className;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }
}

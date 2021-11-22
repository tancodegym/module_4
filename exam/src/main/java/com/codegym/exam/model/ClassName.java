package com.codegym.exam.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;
    @OneToMany(targetEntity = Student.class)
    private Set<Student> studentList;

    public ClassName() {


    }

    public ClassName(String className, Set<Student> studentList) {
        this.className = className;
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}


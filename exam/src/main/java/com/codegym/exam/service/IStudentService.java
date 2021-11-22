package com.codegym.exam.service;

import com.codegym.exam.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getList();
    Student findById(Long id);
    void save(Student student);
    void update(Student student);
    void delete(Long id);

}

package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplement implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        Student student = iStudentRepository.findById(id).get();
        return student;

    }

    @Override
    public void remove(int id) {
        iStudentRepository.delete(findById(id));
    }
}

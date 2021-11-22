package com.codegym.exam.service;

import com.codegym.exam.model.Student;
import com.codegym.exam.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements  IStudentService{
    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public List<Student> getList() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return iStudentRepository.findById(id).get();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);

    }

    @Override
    public void update(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        iStudentRepository.delete(findById(id));
    }
}

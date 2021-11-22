package com.codegym.exam.service;

import com.codegym.exam.model.ClassName;
import com.codegym.exam.repository.IClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements IClassNameService{
    @Autowired
    IClassNameRepository iClassNameRepository;
    @Override
    public List<ClassName> getList() {
        return iClassNameRepository.findAll();
    }
}

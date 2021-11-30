package com.example.demo.service;

import com.example.demo.model.Pig;
import com.example.demo.repository.PigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PigServiceImpl implements IPigService{
    @Autowired
    PigRepository pigRepository;
    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }
}

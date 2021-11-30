package com.example.demo.service;

import com.example.demo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPigService {
    List<Pig> findAll();
    Pig findById(Long id);
    void update(Pig pig);
    void delete(Long id);
    Page<Pig> search(Pageable pageable,String status, String pigCode, String country);
}

package com.example.demo.service;

import com.example.demo.model.Pig;
import com.example.demo.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigServiceImpl implements IPigService{
    @Autowired
    IPigRepository iPigRepository;
    @Override
    public List<Pig> findAll() {
        return iPigRepository.findAll();
    }

    @Override
    public Pig findById(Long id) {
        return iPigRepository.findById(id).get();
    }

    @Override
    public void update(Pig pig) {
        iPigRepository.save(pig);
    }

    @Override
    public void delete(Long id) {
        iPigRepository.delete(findById(id));
    }

    @Override
    public Page<Pig> search(Pageable pageable, String status, String pigCode, String country) {
        return iPigRepository.search(pageable,"%"+status+"%","%"+pigCode+"%","%"+country+"%");
    }
}

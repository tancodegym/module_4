package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    ICountryRepository iCountryRepository;


    @Override
    public List<Country> findAll() {
        return iCountryRepository.findAll();
    }
}

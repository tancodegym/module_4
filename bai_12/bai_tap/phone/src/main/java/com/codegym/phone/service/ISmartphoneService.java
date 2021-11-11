package com.codegym.phone.service;

import com.codegym.phone.model.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);

    void update(SmartPhone smartPhone);
}

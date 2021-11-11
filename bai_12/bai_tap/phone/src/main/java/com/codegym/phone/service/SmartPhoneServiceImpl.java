package com.codegym.phone.service;

import com.codegym.phone.model.SmartPhone;
import com.codegym.phone.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SmartPhoneServiceImpl implements ISmartphoneService{
    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartPhoneRepository.delete(findById(id).get());
    }

    @Override
    public void update(SmartPhone smartPhone) {
        iSmartPhoneRepository.save(smartPhone);
    }
}

package com.codegym.service;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepositoryImpl;
import com.codegym.repository.IEmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {
    IEmailRepository iEmailRepository = new EmailRepositoryImpl();
    @Override
    public Email getEmail() {
        return iEmailRepository.getEmail();
    }

    @Override
    public void updateEmail(Email email) {
        iEmailRepository.updateEmail(email);

    }
}

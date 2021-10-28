package com.codegym.service;

import com.codegym.model.Email;

public interface IEmailService {
    Email getEmail();
    void updateEmail(Email email);
}

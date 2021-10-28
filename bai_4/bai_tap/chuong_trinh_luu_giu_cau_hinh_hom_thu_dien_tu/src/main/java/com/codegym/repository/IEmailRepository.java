package com.codegym.repository;

import com.codegym.model.Email;

public interface IEmailRepository {
    Email getEmail();

    void updateEmail(Email email);
}

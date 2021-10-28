package com.codegym.repository;

import com.codegym.model.Email;

public class EmailRepositoryImpl implements IEmailRepository {
    private static Email email= new Email(new String[] {"English"},new int[] {5,10},0,"Flash");

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public void updateEmail(Email newEmail) {
        email=newEmail;
    }
}

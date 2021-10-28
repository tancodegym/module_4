package com.codegym.service;

import com.codegym.model.Person;

public interface IPersonService {
    void save(Person person);
    Person getInfo();
}

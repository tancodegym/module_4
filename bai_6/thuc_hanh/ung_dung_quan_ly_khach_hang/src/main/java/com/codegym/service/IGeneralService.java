package com.codegym.service;

import java.util.List;

public interface IGeneralService<C> {
    List<C> findAll();

    C findById(Long id);

    void save(C c);

    void remove(Long id);
}

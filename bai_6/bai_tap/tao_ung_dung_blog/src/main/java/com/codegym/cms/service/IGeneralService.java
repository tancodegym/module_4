package com.codegym.cms.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(int id);
    void update(T t);

    void save(T t);

    void remove(int id);
}

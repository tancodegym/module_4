package com.codegym.cms.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(int id);
     void update(T t);

    void save(T t);

    void remove(int id);

}

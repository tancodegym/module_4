package com.codegym.repository;
import java.util.List;
public interface IGeneralRepository<C> {
    List<C> findAll();

    C findById(Long id);

    void save(C c);

    void remove(Long id);
}

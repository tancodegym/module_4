package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<C> {
    Iterable<C> findAll();

    Optional<C> findById(Long id);

    void save(C t);

    void remove(Long id);
}

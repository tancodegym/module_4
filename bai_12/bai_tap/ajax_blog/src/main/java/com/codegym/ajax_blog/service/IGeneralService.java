package com.codegym.ajax_blog.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);
    void update(T t);

    void save(T t);

    void remove(Long id);
}

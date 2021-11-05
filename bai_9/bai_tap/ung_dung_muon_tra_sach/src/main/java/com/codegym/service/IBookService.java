package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    Book findById(Long id);
    List<Book> findAll();
    void update(Book book);
}

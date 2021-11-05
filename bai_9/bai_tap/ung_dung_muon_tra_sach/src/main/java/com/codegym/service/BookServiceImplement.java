package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void update(Book book) {
        iBookRepository.save(book);
    }
}

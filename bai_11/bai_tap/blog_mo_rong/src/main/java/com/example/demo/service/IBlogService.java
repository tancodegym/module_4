package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService  extends IGeneralService<Blog>{
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String title,  String idCategory);

    List<Blog> findByIdCategory(Long id);
}

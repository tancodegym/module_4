package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

import java.util.List;
import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.remove(id);
    }
}

package com.codegym.ajax_blog.service;

import com.codegym.ajax_blog.model.Blog;
import com.codegym.ajax_blog.model.Category;
import com.codegym.ajax_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        int newId = Math.toIntExact(id);
        return iBlogRepository.findById(newId);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.delete(findById(id).get());
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return iBlogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String title, String idCategory) {
        return iBlogRepository.findAll(pageable,"%"+title+"%","%"+idCategory+"%");
    }

    @Override
    public List<Blog> findByIdCategory(Long id) {
        return iBlogRepository.findByIdCategory("%"+id+"%");
    }

    @Override
    public List<Blog> findByTitle( String title) {
        List<Blog> blogList= iBlogRepository.findByTitle("%"+title+"%");
        return blogList;
    }

}

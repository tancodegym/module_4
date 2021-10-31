package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import java.util.List;

@Transactional
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(Blog blog) {
        Blog originBlog = findById(blog.getId());
        if(originBlog !=null){
            entityManager.merge(blog);
        }
    }

    @Override
    public void save(Blog blog) {
        Blog originBlog = findById(blog.getId());
        if (originBlog != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(int id) {
        Blog blog = findById(id);
        if(blog !=null){
            entityManager.remove(blog);
        }

    }
}

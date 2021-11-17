package com.codegym.repository;


import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Iterable<Blog> findAllByCategory(Category category);
    @Query(value="select * from Blogs where title like :title and category_id like :id",nativeQuery=true)
    Page<Blog> findAll(Pageable pageable,@Param("title") String title,@Param("id") String idCategory);

    @Query(value="select * from Blogs where  category_id like :id",nativeQuery=true)
    List<Blog> findByIdCategory(@Param("id") String idCategory);
}

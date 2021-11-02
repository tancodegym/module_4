package com.example.demo.repository;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Iterable<Blog> findAllByCategory(Category category);
    @Query(value="select * from Blogs where title like :title and category_id like :id",nativeQuery=true)
    Page<Blog> findAll(Pageable pageable,@Param("title") String title,@Param("id") String idCategory);
}

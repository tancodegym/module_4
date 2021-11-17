package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired
    ICategoryService iCategoryService;
    //Xem danh sách category
    @GetMapping("/category")
    public List<Category> getListCategory(){
        List<Category> categoryList = iCategoryService.findAll();
        return categoryList;
    }

}

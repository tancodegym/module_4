package com.example.demo.formatter;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ICategoryService;
import org.springframework.core.convert.converter.Converter;

public class StringToCategoryFormatter implements Converter<Long, Category> {
    ICategoryService iCategoryService = new CategoryService();
    @Override
    public Category convert(Long id) {
        Category  category ;
        category = iCategoryService.findById(id).get();
        return category;
    }
}

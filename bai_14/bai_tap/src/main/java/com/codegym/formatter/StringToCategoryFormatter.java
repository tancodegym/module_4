package com.codegym.formatter;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import com.codegym.service.ICategoryService;
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

package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.Category;
import com.example.ludotecatanback.category.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    Category get(Long id);

    List<Category> findAll();
    void save(Long id, CategoryDto categoryDto);
    void delete(Long id) throws Exception;

}

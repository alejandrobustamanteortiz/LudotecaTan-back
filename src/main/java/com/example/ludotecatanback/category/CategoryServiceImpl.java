package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.Category;
import com.example.ludotecatanback.category.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void save(Long id, CategoryDto categoryDto) {

        Category category;

        if (id == null) {
            category = new Category();
        } else {
            category = this.categoryRepository.findById(id).orElse(null);
        }
        category.setName(categoryDto.getName());
        this.categoryRepository.save(category);

    }

    @Override
    public void delete(Long id) throws Exception {

        if(this.categoryRepository.findById(id).orElse(null) == null){
            throw new Exception("Not exists");
        }

        this.categoryRepository.deleteById(id);
    }
}

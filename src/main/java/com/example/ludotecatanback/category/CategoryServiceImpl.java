package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.Category;
import com.example.ludotecatanback.category.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category get(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

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
            category = this.get(id);
        }
        category.setName(categoryDto.getName());
        this.categoryRepository.save(category);

    }

    @Override
    public void delete(Long id) throws Exception {

        if(this.get(id) == null){
            throw new Exception("Not exists");
        }

        this.categoryRepository.deleteById(id);
    }
}

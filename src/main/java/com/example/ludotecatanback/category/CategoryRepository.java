package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

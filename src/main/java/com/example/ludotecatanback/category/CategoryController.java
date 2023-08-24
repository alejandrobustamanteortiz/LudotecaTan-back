package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.Category;
import com.example.ludotecatanback.category.model.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Category", description = "API of Category")
@RequestMapping(value = "/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Find", description = "Method that returns a list of Categories")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CategoryDto> findAll() {

        List<Category> categories = this.categoryService.findAll();
        return categories.stream().map(e -> mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
    }

    @Operation(summary = "Save or Update", description = "Method that save or updates a category")
    @RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody CategoryDto categoryDto) {

        categoryService.save(id, categoryDto);
    }

    @Operation(summary = "Delete", description = "Method that deletes a Category")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.categoryService.delete(id);
    }
}

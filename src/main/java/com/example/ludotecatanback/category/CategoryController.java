package com.example.ludotecatanback.category;

import com.example.ludotecatanback.category.model.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Category", description = "API of Category")
@RequestMapping(value = "/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private long SEQUENCE = 1;
    private Map<Long, CategoryDto> categories = new HashMap<Long, CategoryDto>();

    @Operation(summary = "Find", description = "Method that returns a list of Categories")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CategoryDto> findAll() {

        return new ArrayList<CategoryDto>(this.categories.values());
    }

    @Operation(summary = "Save or Update", description = "Method that save or updates a category")
    @RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody CategoryDto categoryDto) {

        CategoryDto category;

        if (id == null) {
            category = new CategoryDto();
            category.setId(this.SEQUENCE++);
            this.categories.put(category.getId(), category);

        } else {
            category = this.categories.get(id);
        }

        category.setName(categoryDto.getName());

    }
}

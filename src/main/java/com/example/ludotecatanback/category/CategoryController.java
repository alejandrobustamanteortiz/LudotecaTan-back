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

@RestController // indica que esta clase es un controlador que maneja solicitudes HTTP y produce resultados JSON
@Tag(name = "Category", description = "API of Category") //anotación de Swagger para categorizar y documentar endpoints
@RequestMapping(value = "/category") //Define el mapeo de ruta base para todos los métodos dentro de este controlador
@CrossOrigin(origins = "*") //Permite solicitudes desde cualquier origen
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ModelMapper mapper; //herramienta para mapear objetos de una clase a otra de manera automatizada y configurada

    @Operation(summary = "Find", description = "Method that returns a list of Categories")
    @RequestMapping(path = "", method = RequestMethod.GET)
    @GetMapping("")
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

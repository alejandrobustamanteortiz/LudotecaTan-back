package com.example.ludotecatanback.category;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name= "Category", description="API of Category")
@RequestMapping(value= "/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String prueba(){
        return "Hola estoy probando un controlador";
    }
}

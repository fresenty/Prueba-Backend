// Import necessary classes and packages
package com.fredy.pruebanexsys.controller;

import com.fredy.pruebanexsys.dto.response.CategoryGetAllDto; // Import CategoryGetAllDto class
import com.fredy.pruebanexsys.service.CategoryService; // Import CategoryService class
import org.springframework.http.HttpStatus; // Import HttpStatus class
import org.springframework.http.ResponseEntity; // Import ResponseEntity class
import org.springframework.web.bind.annotation.GetMapping; // Import GetMapping annotation
import org.springframework.web.bind.annotation.RequestMapping; // Import RequestMapping annotation
import org.springframework.web.bind.annotation.RestController; // Import RestController annotation

import java.util.List; // Import List class

@RestController // Annotation indicating that the class is a REST controller
@RequestMapping("/nexsys/v1/categories") // Annotation specifying the base path for all requests handled by the controller
public class CategoryController {

    private final CategoryService categoryService; // Declaration of an instance of CategoryService

    // Constructor for the class, which accepts an instance of CategoryService and stores it in an instance field for later use
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Method handling HTTP GET requests to the controller's base path
    @GetMapping
    public ResponseEntity<List<CategoryGetAllDto>> getAllCategories() {
        // Returns a list of CategoryGetAllDto objects and wraps it in an HTTP response ResponseEntity with HttpStatus.OK status
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}

package com.eilco.ecomm.controllers;

import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.repositories.entities.Category;
import com.eilco.ecomm.services.implementations.CategoryService;
import com.eilco.ecomm.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/category")
@RestController
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable("id") Long id) {

        return categoryService.findMyCategoryById(id);
    }

    @GetMapping
    public List<CategoryResponse> list() {
        return categoryService.findMyAllCategories();
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> searchByName(@RequestParam String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Search name cannot be empty");
        }
        return ResponseEntity.ok(categoryService.findMyCategoryByName(name));
    }


}

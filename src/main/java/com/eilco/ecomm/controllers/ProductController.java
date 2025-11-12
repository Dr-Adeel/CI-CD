package com.eilco.ecomm.controllers;

import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.models.response.ProductResponse;
import com.eilco.ecomm.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long id) {

        return productService.findMyProductById(id);
    }

    @GetMapping
    public List<ProductResponse> list() {
        return productService.findMyAllProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchByName(@RequestParam String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Search name cannot be empty");
        }
        return ResponseEntity.ok(productService.findMyProductByName(name));
    }


}

package com.eilco.ecomm.controllers.seller;

import com.eilco.ecomm.models.request.CategoryRequest;
import com.eilco.ecomm.models.request.ProductRequest;
import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.models.response.ProductResponse;
import com.eilco.ecomm.services.interfaces.ISellerProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/product-seller")
@RestController
public class ProductSellerConrtroller {

    private final ISellerProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.saveProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}

package com.eilco.ecomm.mappers;

import com.eilco.ecomm.models.request.ProductRequest;
import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.models.response.ProductResponse;
import com.eilco.ecomm.repositories.CategoryRepository;
import com.eilco.ecomm.repositories.entities.Category;
import com.eilco.ecomm.repositories.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductMapper {

    CategoryRepository categoryRepository;

    public Product toEntity(ProductRequest productRequest) {
        log.info("ProductMapper:toEntity");

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + productRequest.getCategoryId()));

        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .category(category)
                .build();
    }

    public ProductResponse toResponse(Product product){
        log.info("ProductMapper:toResponse");
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .updatedAt(product.getUpdatedAt())
                .categoryId(product.getCategory().getId())
                .build();
    }


}
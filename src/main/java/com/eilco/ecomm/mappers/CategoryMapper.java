package com.eilco.ecomm.mappers;

import com.eilco.ecomm.models.request.CategoryRequest;
import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.repositories.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }

    public CategoryResponse toResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }


}
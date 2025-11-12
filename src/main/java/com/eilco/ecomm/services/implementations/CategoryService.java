package com.eilco.ecomm.services.implementations;

import com.eilco.ecomm.mappers.CategoryMapper;
import com.eilco.ecomm.models.response.CategoryResponse;
import com.eilco.ecomm.repositories.CategoryRepository;
import com.eilco.ecomm.repositories.entities.Category;
import com.eilco.ecomm.services.interfaces.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

   @Override
   public List<CategoryResponse> findMyCategoryByName(String name){
       List<Category> categories = categoryRepository.findByNameContainingIgnoreCase(name);
       return categories.isEmpty()
               ? Collections.emptyList()
               : categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse findMyCategoryById(Long id){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> {
            return new RuntimeException("Category not found");
        });
        return categoryMapper.toResponse(category);

    }


    @Override
    public List<CategoryResponse> findMyAllCategories(){

        List<Category> categories = categoryRepository.findAll();
        return categories.isEmpty()
                ? Collections.emptyList()
                : categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());

    }


}

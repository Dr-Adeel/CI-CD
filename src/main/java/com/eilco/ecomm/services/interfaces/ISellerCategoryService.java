package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.request.CategoryRequest;
import com.eilco.ecomm.models.response.CategoryResponse;

public interface ISellerCategoryService {
    CategoryResponse saveCategory(CategoryRequest categoryRequest);
    void deleteCategory(Long id);
    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);
}

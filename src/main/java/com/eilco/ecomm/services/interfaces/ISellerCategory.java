package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.response.CategoryResponse;

public interface ISellerCategory {
    CategoryResponse saveCategory(CategoryResponse categoryResponse);
    void deleteCategory(Long id);
    CategoryResponse updateCategory(CategoryResponse categoryResponse);
}

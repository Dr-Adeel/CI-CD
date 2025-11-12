package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {

    //List<CategoryResponse> findAllCategory();
    CategoryResponse findMyCategoryById(Long id);
    List<CategoryResponse> findMyCategoryByName(String name);
    List<CategoryResponse> findMyAllCategories();

}

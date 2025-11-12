package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {

    //List<CategoryResponse> findAllCategory();
    CategoryResponse findCategoryById(Long id);
    CategoryResponse findCategoryByName(String name);

}

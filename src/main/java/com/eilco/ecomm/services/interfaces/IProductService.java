package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.response.ProductResponse;

import java.util.List;

public interface IProductService {

    ProductResponse findMyProductById(Long id);

    List<ProductResponse> findMyProductByName(String name);

    List<ProductResponse> findMyAllProducts();

}

package com.eilco.ecomm.services.interfaces;

import com.eilco.ecomm.models.request.ProductRequest;
import com.eilco.ecomm.models.response.ProductResponse;

public interface ISellerProductService {
    ProductResponse saveProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long id);
}

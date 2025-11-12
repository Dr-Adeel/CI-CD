package com.eilco.ecomm.services.implementations;

import com.eilco.ecomm.mappers.ProductMapper;
import com.eilco.ecomm.models.request.ProductRequest;
import com.eilco.ecomm.models.response.ProductResponse;
import com.eilco.ecomm.repositories.ProductRepository;
import com.eilco.ecomm.repositories.entities.Product;
import com.eilco.ecomm.services.interfaces.IProductService;
import com.eilco.ecomm.services.interfaces.ISellerProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService implements IProductService, ISellerProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

   @Override
   public List<ProductResponse> findMyProductByName(String name){
       log.info("ProductService:findMyProductByName");
       List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
       return products.isEmpty()
               ? Collections.emptyList()
               : products.stream().map(productMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findMyProductById(Long id){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
            return new RuntimeException("Product not found");
        });
        return productMapper.toResponse(product);
    }


    @Override
    public List<ProductResponse> findMyAllProducts(){

        List<Product> products = productRepository.findAll();
        return products.isEmpty()
                ? Collections.emptyList()
                : products.stream().map(productMapper::toResponse).collect(Collectors.toList());

    }

    public ProductResponse saveProduct(ProductRequest productRequest){
       return productMapper.toResponse(
               productRepository.save(
                       productMapper.toEntity(productRequest)));
    }

   public void deleteProduct(Long id){
       productRepository.deleteById(id);
   }

   public ProductResponse updateProduct(Long id, ProductRequest productRequest){

       Product existingProduct = productRepository.findById(id)
               .orElseThrow(() -> {
                   return  new RuntimeException("Product not found");
               });

       existingProduct.setName(productRequest.getName());

       return productMapper.toResponse(productRepository.save(existingProduct));
   }

}

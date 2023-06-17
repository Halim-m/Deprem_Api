package com.hack.deprem.service;

import com.hack.deprem.dto.request.CreateProductRequest;
import com.hack.deprem.model.Product;
import com.hack.deprem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //create
    protected Product createProduct(CreateProductRequest request){
        Product product = new Product(request.productName(), request.number(), request.isHuman(), request.phoneNumber());
        productRepository.save(product);
        return product;
    }
}
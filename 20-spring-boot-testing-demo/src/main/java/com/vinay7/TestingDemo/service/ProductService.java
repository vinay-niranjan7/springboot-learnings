package com.vinay7.TestingDemo.service;


import com.vinay7.TestingDemo.entity.Product;
import com.vinay7.TestingDemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + id)
                );
    }

    public Product createProduct(Product product) {

        boolean alreadyExists =
                productRepository.existsByName(product.getName());

        if (alreadyExists) {
            throw new IllegalArgumentException(
                    "Product already exists"
            );
        }

        return productRepository.save(product);
    }
}
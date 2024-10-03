package com.project.desimandi.service;

import com.project.desimandi.entity.Product;
import com.project.desimandi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> fetchAllProducts(){
        return repository.findAll();
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }
import com.project.desimandi.dto.ProductDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(UUID id);

    ProductDTO saveProduct(ProductDTO productDTO);

    void deleteProduct(UUID id);

    List<ProductDTO> getProductsByCategory(String category);
}

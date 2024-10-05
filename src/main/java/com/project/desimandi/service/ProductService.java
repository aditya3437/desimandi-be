package com.project.desimandi.service;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> fetchAllProducts();

    Optional<ProductDTO> getProductById(UUID id);

    Product addProduct(Product product);

    ProductDTO saveProduct(ProductDTO productDTO);

    void deleteProduct(UUID id);

    List<ProductDTO> getProductsByCategory(String category);
}

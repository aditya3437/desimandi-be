package com.project.desimandi.service;

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

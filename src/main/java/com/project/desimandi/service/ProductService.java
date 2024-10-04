package com.project.desimandi.service;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.entity.Product;
import com.project.desimandi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProductService {

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(UUID id);

    ProductDTO saveProduct(ProductDTO productDTO);

    void deleteProduct(UUID id);

    List<ProductDTO> getProductsByCategory(String category);
}

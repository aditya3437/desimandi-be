package com.project.desimandi.service.impl;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.model.Product;
import com.project.desimandi.repository.ProductRepository;
import com.project.desimandi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(UUID id) {
        return productRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        return convertToDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategory(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Product to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .build();
    }

    // Convert ProductDTO to Product
    private Product convertToEntity(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .description(productDTO.getDescription())
                .imageUrl(productDTO.getImageUrl())
                .build();
    }
}

package com.project.desimandi.controller;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Retrieves all products.
     *
     * @return a ResponseEntity containing a list of ProductDTO objects.
     */
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the UUID of the product to retrieve.
     * @return a ResponseEntity containing the ProductDTO if found, or a 404 Not Found response.
     */
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product.
     *
     * @param productDTO the ProductDTO containing product details to be created.
     * @return a ResponseEntity containing the created ProductDTO with a 201 Created status.
     */
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.saveProduct(productDTO);
        return ResponseEntity.status(201).body(createdProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the UUID of the product to delete.
     * @return a ResponseEntity with no content (204 No Content).
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates an existing product.
     *
     * @param id         the UUID of the product to update.
     * @param productDTO the ProductDTO containing updated product details.
     * @return a ResponseEntity containing the updated ProductDTO.
     */
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable UUID id,
            @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        ProductDTO updatedProduct = productService.saveProduct(productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Retrieves a list of products by their category.
     *
     * @param category the category of the products to retrieve
     * @return a ResponseEntity containing a list of ProductDTO objects
     *         matching the specified category, or an empty list if none found
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) {
        List<ProductDTO> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }
}

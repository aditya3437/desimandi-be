package com.project.desimandi.controller;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.entity.Product;
import com.project.desimandi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/desimandi")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Retrieves all products.
     *
     * @return a list of all Product entities.
     */
    @GetMapping("/products")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    /**
     * Adds a new product.
     *
     * @param product the Product entity to add.
     * @return the added Product entity.
     */
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the UUID of the product to retrieve.
     * @return a ResponseEntity containing the ProductDTO if found, or a 404 Not Found response.
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the UUID of the product to delete.
     * @return a ResponseEntity with no content status.
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
     * Retrieves products by category.
     *
     * @param category the category of the products to retrieve.
     * @return a ResponseEntity containing a list of ProductDTO objects matching the specified category.
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) {
        List<ProductDTO> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }
}

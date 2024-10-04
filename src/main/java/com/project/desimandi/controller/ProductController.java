package com.project.desimandi.controller;

import com.project.desimandi.dto.ProductDTO;
import com.project.desimandi.entity.Product;
import com.project.desimandi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desimandi")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getName(){
        return productService.fetchAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);

    /**
     * Retrieves a product by its ID.
     *
     * @param id the UUID of the product to retrieve.
     * @return a ResponseEntity containing the ProductDTO if found, or a 404 Not Found response.
     */
    @GetMapping
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

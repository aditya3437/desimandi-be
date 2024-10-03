package com.project.desimandi.controller;

import com.project.desimandi.entity.Product;
import com.project.desimandi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desimandi")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getName(){
        return service.fetchAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }
}

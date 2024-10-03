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
}

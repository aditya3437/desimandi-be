package com.project.desimandi.model;

import com.project.desimandi.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private UUID id;

    @Field("name")
    private String name;

    @Field("category")
    private Category category;

    @Field("price")
    private Double price;

    @Field("quantity")
    private Integer quantity;

    @Field("description")
    private String description;

    @Field("imageUrl")
    private String imageUrl;

    // Constructor to generate a new UUID when a product is created
    public Product(String name, Category category, Double price, Integer quantity, String description, String imageUrl) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}

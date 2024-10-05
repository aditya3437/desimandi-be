package com.project.desimandi.entity;

import com.project.desimandi.enums.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private UUID id;

    private String productName;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private String imageUrl;
    private Category category;
    private int quantity;
    private String description;

    public Product(String productName, BigDecimal buyPrice, BigDecimal sellPrice, String imageUrl, Category category, int quantity, String description) {
        this.id = UUID.randomUUID();
        this.productName = productName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.imageUrl = imageUrl;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
    }
}

package com.project.desimandi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document(collection = "product")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
    @Id
    private UUID id;
    private String productName ;
    private BigDecimal buyPrice;
    private BigDecimal price;
    private String imageUrl ;

    Product(){
        this.id = UUID.randomUUID(); // Automatically generate UUID̵
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product(String imageUrl, BigDecimal price, BigDecimal buyPrice, String productName, UUID id) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.buyPrice = buyPrice;
        this.productName = productName;
        this.id = id;
    }
}

package com.project.desimandi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
    @Id
    private String UUID;
    private String productName ;
    private BigDecimal buyPrice;
    private BigDecimal price;
    private String imageUrl ;


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
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

    public Product(String imageUrl, BigDecimal price, BigDecimal buyPrice, String productName, String UUID) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.buyPrice = buyPrice;
        this.productName = productName;
        this.UUID = UUID;
    }
}

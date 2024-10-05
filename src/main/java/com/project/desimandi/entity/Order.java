package com.project.desimandi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private UUID orderId;
    private List<Product> products;
    private Integer quantity;
    private String userMobileNumber;

    public Order(List<Product> products, Integer quantity, String userMobileNumber) {
        this.orderId = UUID.randomUUID();
        this.products = products;
        this.quantity = quantity;
        this.userMobileNumber = userMobileNumber;
    }
}

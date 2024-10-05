package com.project.desimandi.dto;

import com.project.desimandi.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private UUID orderId;
    private List<Product> products;
    private Integer quantity;
    private String userMobileNumber;
}

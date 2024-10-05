package com.project.desimandi.dto;

import com.project.desimandi.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private UUID id;

    private String productName;

    private BigDecimal buyPrice;

    private BigDecimal sellPrice;

    private String imageUrl;

    private Category category;

    private Integer quantity;

    private String description;
}

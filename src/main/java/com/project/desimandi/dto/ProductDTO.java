package com.project.desimandi.dto;

import com.project.desimandi.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private UUID id;

    private String name;

    private Category category;

    private Double price;

    private Integer quantity;

    private String description;

    private String imageUrl;
}

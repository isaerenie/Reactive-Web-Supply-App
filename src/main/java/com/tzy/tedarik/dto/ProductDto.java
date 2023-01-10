package com.tzy.tedarik.dto;

import com.tzy.tedarik.model.products.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Product} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer Id;
    private String productName;
    private Integer quantity;
    private Double price;
}
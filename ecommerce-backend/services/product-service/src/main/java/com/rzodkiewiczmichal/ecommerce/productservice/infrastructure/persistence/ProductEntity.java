package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
public record ProductEntity(
    @Id String id,
    String name,
    String description,
    BigDecimal price
) {
}
package com.rzodkiewiczmichal.ecommerce.productservice.domain;

/**
 * Value Object representing the unique identifier of a Product aggregate.
 */
public record ProductId(String value) {
    public ProductId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Product id must not be null or empty");
        }
    }
}


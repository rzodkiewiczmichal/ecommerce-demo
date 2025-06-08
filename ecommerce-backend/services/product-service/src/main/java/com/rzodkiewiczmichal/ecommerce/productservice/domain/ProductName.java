package com.rzodkiewiczmichal.ecommerce.productservice.domain;

/**
 * Value Object representing the name of a Product.
 */
public record ProductName(String value) {
    public ProductName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Product name must not be null or blank");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("Product name must not exceed 255 characters");
        }
    }
}
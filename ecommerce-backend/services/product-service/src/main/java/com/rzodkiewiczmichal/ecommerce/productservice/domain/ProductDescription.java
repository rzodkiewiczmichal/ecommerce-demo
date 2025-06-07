package com.rzodkiewiczmichal.ecommerce.productservice.domain;

/**
 * Value Object representing the description of a Product.
 */
record ProductDescription(String value) {
    public ProductDescription {
        if (value == null) {
            throw new IllegalArgumentException("Product description must not be null");
        }
        if (value.length() > 1000) {
            throw new IllegalArgumentException("Product description must not exceed 1000 characters");
        }
    }
}

package com.rzodkiewiczmichal.ecommerce.productservice.domain;

/**
 * Aggregate root for Product in the domain model.
 * Represents a product entity and its invariants within the product service.
 */
public record Product(
        ProductId id,
        ProductName name,
        ProductDescription description,
        Price price
) {
    public Product {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (description == null) {
            throw new IllegalArgumentException("description must not be null");
        }
        if (price == null) {
            throw new IllegalArgumentException("price must not be null");
        }
    }
}

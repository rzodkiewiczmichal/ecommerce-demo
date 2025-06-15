package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;

/**
 * Product representation in Order Service bounded context.
 * Contains only the product data needed for order processing.
 */
public record Product(
    ProductId id,
    String name,
    Money price,
    boolean available
) {
}
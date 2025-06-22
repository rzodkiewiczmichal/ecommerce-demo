package com.rzodkiewiczmichal.ecommerce.productservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import jakarta.validation.constraints.NotNull;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

/**
 * Aggregate root for Product in the domain model.
 * Represents a product entity and its invariants within the product service.
 */
public record Product(
        @NotNull ProductId id,
        @NotNull ProductName name,
        @NotNull ProductDescription description,
        @NotNull Money price
) {
    public Product {
        ValidationUtils.validate(this);
    }
}

package com.rzodkiewiczmichal.ecommerce.productservice.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

/**
 * Value Object representing the description of a Product.
 */
public record ProductDescription(
    @NotNull @Size(max = 1000) String value
) {
    public ProductDescription {
        ValidationUtils.validate(this);
    }
}

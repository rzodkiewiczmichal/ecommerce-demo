package com.rzodkiewiczmichal.ecommerce.productservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

/**
 * Value Object representing the name of a Product.
 */
public record ProductName(
    @NotBlank @Size(max = 255) String value
) {
    public ProductName {
        ValidationUtils.validate(this);
    }
}
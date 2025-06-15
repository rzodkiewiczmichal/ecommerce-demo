package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.NotBlank;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

public record ProductId(
    @NotBlank String value
) {
    public ProductId {
        ValidationUtils.validate(this);
    }
} 
package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.NotBlank;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

public record CustomerId(
    @NotBlank String value
) {
    public CustomerId {
        ValidationUtils.validate(this);
    }
} 
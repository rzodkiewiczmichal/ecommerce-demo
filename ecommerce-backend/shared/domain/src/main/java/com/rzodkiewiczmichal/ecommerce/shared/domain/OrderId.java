package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.NotBlank;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;
import java.util.UUID;

public record OrderId(
    @NotBlank String value
) {
    public OrderId {
        ValidationUtils.validate(this);
    }

    public static OrderId generate() {
        return new OrderId(UUID.randomUUID().toString());
    }
} 
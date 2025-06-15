package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

public record OrderItem(
    @NotNull ProductId productId,
    @Positive int quantity
) {
    public OrderItem {
        ValidationUtils.validate(this);
    }
} 
package com.rzodkiewiczmichal.ecommerce.productservice.domain;

import java.math.BigDecimal;
import java.util.Currency;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

/**
 * Value Object representing the monetary Price of a Product (amount and currency).
 */
public record Price(
    @NotNull @PositiveOrZero BigDecimal amount,
    @NotNull Currency currency
) {
    public Price {
        ValidationUtils.validate(this);
    }
}

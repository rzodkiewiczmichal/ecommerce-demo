package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;

/**
 * Value Object representing a monetary amount with currency.
 * Used across all services for consistent money handling.
 */
public record Money(
    @NotNull @Positive Double amount,
    @NotNull String currency
) {
    public Money {
        ValidationUtils.validate(this);
    }

    public static Money of(Double amount, String currency) {
        return new Money(amount, currency);
    }

    public static Money zero(String currency) {
        return new Money(0.0, currency);
    }
} 
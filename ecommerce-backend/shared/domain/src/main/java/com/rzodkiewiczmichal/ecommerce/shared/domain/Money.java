package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Value Object representing a monetary amount with currency.
 * Used across all services for consistent money handling.
 */
public record Money(
    @NotNull @PositiveOrZero BigDecimal amount,
    @NotNull Currency currency
) {
    public Money {
        ValidationUtils.validate(this);
    }

    public static Money zero(Currency currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public Money multiply(int quantity) {
        return new Money(amount.multiply(BigDecimal.valueOf(quantity)), currency);
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }
} 
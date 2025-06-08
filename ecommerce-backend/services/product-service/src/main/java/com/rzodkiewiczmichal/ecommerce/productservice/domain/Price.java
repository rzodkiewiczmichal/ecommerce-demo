package com.rzodkiewiczmichal.ecommerce.productservice.domain;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Value Object representing the monetary Price of a Product (amount and currency).
 */
public record Price(BigDecimal amount, Currency currency) {
    public Price {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException("Amount must not be null or negative");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency must not be null");
        }
    }
}

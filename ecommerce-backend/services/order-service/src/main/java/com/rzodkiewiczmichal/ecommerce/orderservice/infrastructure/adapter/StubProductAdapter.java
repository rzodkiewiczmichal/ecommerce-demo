package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.adapter;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.LoadProductPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;

/**
 * Stub implementation for testing purposes.
 * Returns mock product data for any product ID.
 */
@Component
public class StubProductAdapter implements LoadProductPort {

    @Override
    public Optional<Product> loadById(ProductId productId) {
        // Return mock product data for testing
        return Optional.of(new Product(
            productId,
            "Test Product " + productId.value(),
            new Money(new BigDecimal("29.99"), Currency.getInstance("USD")),
            true // available
        ));
    }
}
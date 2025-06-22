package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;

import java.util.Currency;
import java.util.List;
import java.util.function.Function;

/**
 * Value Object representing the total amount for an order.
 * Encapsulates the calculation logic for order totals.
 */
public record OrderTotal(Money amount) {
    
    public static OrderTotal calculate(List<OrderItem> items, Function<OrderItem, Product> productResolver) {
        Money totalAmount = items.stream()
            .map(item -> {
                Product product = productResolver.apply(item);
                return product.price().multiply(item.quantity());
            })
            .reduce(Money.zero(Currency.getInstance("USD")), (total, itemTotal) -> total.add(itemTotal));
        
        return new OrderTotal(totalAmount);
    }
} 
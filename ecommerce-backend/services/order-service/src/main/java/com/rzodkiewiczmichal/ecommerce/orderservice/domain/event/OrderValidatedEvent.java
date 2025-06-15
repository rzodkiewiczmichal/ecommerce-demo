package com.rzodkiewiczmichal.ecommerce.orderservice.domain.event;

import com.rzodkiewiczmichal.ecommerce.shared.domain.CustomerId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;

import java.time.Instant;

/**
 * Domain event published when an order has been validated.
 * Consumed by Payment service to initiate payment processing.
 */
public record OrderValidatedEvent(
    OrderId orderId,
    CustomerId customerId,
    Money totalAmount,
    Instant occurredAt
) {
    public static OrderValidatedEvent of(OrderId orderId, CustomerId customerId, Money totalAmount) {
        return new OrderValidatedEvent(orderId, customerId, totalAmount, Instant.now());
    }
}
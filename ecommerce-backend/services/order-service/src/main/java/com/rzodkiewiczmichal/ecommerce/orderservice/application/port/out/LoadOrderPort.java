package com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;

import java.util.Optional;

/**
 * Port for loading orders from external storage.
 * Implementation should be provided by the infrastructure layer.
 */
public interface LoadOrderPort {
    Optional<Order> loadById(OrderId orderId);
} 
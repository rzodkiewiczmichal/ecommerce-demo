package com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;

/**
 * Port for saving orders to external storage.
 * Implementation should be provided by the infrastructure layer.
 */
public interface SaveOrderPort {
    Order save(Order order);
} 
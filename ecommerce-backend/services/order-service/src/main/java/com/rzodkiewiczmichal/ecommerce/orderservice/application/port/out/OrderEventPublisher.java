package com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;

public interface OrderEventPublisher {
    void publishOrderValidated(Order order);
} 
package com.rzodkiewiczmichal.ecommerce.orderservice.application.port.in;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.PlaceOrderCommand;

public interface PlaceOrderUseCase {
    Order placeOrder(PlaceOrderCommand command);
} 
package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.LoadProductPort;

/**
 * Domain service for order validation logic.
 * Validates business rules before order creation.
 */
public class OrderValidationService {
    
    private final LoadProductPort loadProductPort;
    
    public OrderValidationService(LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }
    
    public void validateOrder(PlaceOrderCommand command) {
        validateProductsExist(command);
        validateOrderItems(command);
    }
    
    private void validateProductsExist(PlaceOrderCommand command) {
        command.items().forEach(item -> {
            Product product = loadProductPort.loadById(item.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + item.productId()));
            
            if (!product.available()) {
                throw new IllegalArgumentException("Product not available: " + item.productId());
            }
        });
    }
    
    private void validateOrderItems(PlaceOrderCommand command) {
        command.items().forEach(item -> {
            if (item.quantity() <= 0) {
                throw new IllegalArgumentException("Invalid quantity for product: " + item.productId());
            }
        });
    }
}
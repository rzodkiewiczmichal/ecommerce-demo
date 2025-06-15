package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "orders")
public record OrderEntity(
    @Id String id,
    String customerId,
    List<OrderItemEntity> items,
    DeliveryDetailsEntity deliveryDetails,
    String status,
    BigDecimal totalAmount,
    String currency
) {
    
    public record OrderItemEntity(
        String productId,
        Integer quantity
    ) {}
    
    public record DeliveryDetailsEntity(
        String address,
        String city,
        String postalCode,
        String country,
        String email,
        String phone
    ) {}
}
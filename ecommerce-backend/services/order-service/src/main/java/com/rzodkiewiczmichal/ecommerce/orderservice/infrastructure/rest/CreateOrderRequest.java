package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.rest;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.OrderItem;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.PlaceOrderCommand;
import com.rzodkiewiczmichal.ecommerce.shared.domain.CustomerId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.DeliveryDetails;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(
    @NotNull String customerId,
    @NotEmpty List<@Valid OrderItemRequest> items,
    @NotNull @Valid DeliveryDetailsRequest deliveryDetails
) {
    public PlaceOrderCommand toCommand() {
        return new PlaceOrderCommand(
            new CustomerId(customerId),
            items.stream().map(OrderItemRequest::toOrderItem).toList(),
            deliveryDetails.toDomain()
        );
    }

    public record OrderItemRequest(
        @NotNull ProductId productId,
        @NotNull Integer quantity
    ) {
        public OrderItem toOrderItem() {
            return new OrderItem(productId, quantity);
        }
    }

    public record DeliveryDetailsRequest(
        @NotNull String name,
        @NotNull String address,
        @NotNull String city,
        @NotNull String postalCode,
        @NotNull String country,
        @NotNull String email,
        @NotNull String phone
    ) {
        public DeliveryDetails toDomain() {
            return new DeliveryDetails(address, city, postalCode, country, email, phone);
        }
    }
} 
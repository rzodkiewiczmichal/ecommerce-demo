package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.CustomerId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.DeliveryDetails;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PlaceOrderCommand(
    @NotNull CustomerId customerId,
    @NotEmpty List<OrderItem> items,
    @NotNull DeliveryDetails deliveryDetails
) {
    public PlaceOrderCommand {
        ValidationUtils.validate(this);
    }
} 
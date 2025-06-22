package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

import com.rzodkiewiczmichal.ecommerce.shared.domain.CustomerId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.DeliveryDetails;
import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;

import java.util.List;

public class Order {
    private final OrderId id;
    private final CustomerId customerId;
    private final List<OrderItem> items;
    private final DeliveryDetails deliveryDetails;
    private OrderStatus status;
    private final Money totalAmount;

    public Order(OrderId id, CustomerId customerId, List<OrderItem> items, 
                DeliveryDetails deliveryDetails, Money totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.items = List.copyOf(items);
        this.deliveryDetails = deliveryDetails;
        this.status = OrderStatus.PENDING_VALIDATION;
        this.totalAmount = totalAmount;
    }

    public void markAsValidated() {
        this.status = OrderStatus.VALIDATED;
    }

    public void markAsInvalid() {
        this.status = OrderStatus.INVALID;
    }

    public OrderId getId() {
        return id;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }
} 
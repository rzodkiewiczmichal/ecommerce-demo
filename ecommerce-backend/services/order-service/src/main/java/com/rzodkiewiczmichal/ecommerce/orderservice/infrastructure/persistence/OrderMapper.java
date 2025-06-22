package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.OrderItem;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.OrderStatus;
import com.rzodkiewiczmichal.ecommerce.shared.domain.CustomerId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.DeliveryDetails;
import com.rzodkiewiczmichal.ecommerce.shared.domain.Money;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Component
public class OrderMapper {

    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
            order.getId().value(),
            order.getCustomerId().value(),
            order.getItems().stream()
                .map(this::toOrderItemEntity)
                .toList(),
            toDeliveryDetailsEntity(order.getDeliveryDetails()),
            order.getStatus().name(),
            order.getTotalAmount().amount(),
            order.getTotalAmount().currency().getCurrencyCode()
        );
    }

    public Order toDomain(OrderEntity entity) {
        Order order = new Order(
            new OrderId(entity.id()),
            new CustomerId(entity.customerId()),
            entity.items().stream()
                .map(this::toOrderItemDomain)
                .toList(),
            toDeliveryDetailsDomain(entity.deliveryDetails()),
            new Money(entity.totalAmount(), Currency.getInstance(entity.currency()))
        );
        
        // Set the status from persistence
        OrderStatus status = OrderStatus.valueOf(entity.status());
        if (status == OrderStatus.VALIDATED) {
            order.markAsValidated();
        } else if (status == OrderStatus.INVALID) {
            order.markAsInvalid();
        }
        
        return order;
    }

    private OrderEntity.OrderItemEntity toOrderItemEntity(OrderItem item) {
        return new OrderEntity.OrderItemEntity(
            item.productId().value(),
            item.quantity()
        );
    }

    private OrderItem toOrderItemDomain(OrderEntity.OrderItemEntity entity) {
        return new OrderItem(
            new ProductId(entity.productId()),
            entity.quantity()
        );
    }

    private OrderEntity.DeliveryDetailsEntity toDeliveryDetailsEntity(DeliveryDetails details) {
        return new OrderEntity.DeliveryDetailsEntity(
            details.address(),
            details.city(),
            details.postalCode(),
            details.country(),
            details.email(),
            details.phone()
        );
    }

    private DeliveryDetails toDeliveryDetailsDomain(OrderEntity.DeliveryDetailsEntity entity) {
        return new DeliveryDetails(
            entity.address(),
            entity.city(),
            entity.postalCode(),
            entity.country(),
            entity.email(),
            entity.phone()
        );
    }
}
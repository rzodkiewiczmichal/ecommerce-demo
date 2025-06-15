package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.messaging;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.OrderEventPublisher;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.event.OrderValidatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQOrderEventPublisher implements OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final MessagingProperties messagingProperties;

    @Override
    public void publishOrderValidated(Order order) {
        OrderValidatedEvent event = OrderValidatedEvent.of(
            order.getId(),
            order.getCustomerId(),
            order.getTotalAmount()
        );

        try {
            rabbitTemplate.convertAndSend(
                messagingProperties.getOrderValidated().getExchange(),
                messagingProperties.getOrderValidated().getRoutingKey(),
                event
            );
            log.info("Published OrderValidated event for order: {}", order.getId().value());
        } catch (Exception e) {
            log.error("Failed to publish OrderValidated event for order: {}", order.getId().value(), e);
            throw new RuntimeException("Failed to publish order validated event", e);
        }
    }
}
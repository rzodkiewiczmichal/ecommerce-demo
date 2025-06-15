package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.messaging;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.messaging")
public class MessagingProperties {
    
    private final OrderValidated orderValidated = new OrderValidated();
    
    public OrderValidated getOrderValidated() {
        return orderValidated;
    }
    
    public static class OrderValidated {
        private String exchange = "order.exchange";
        private String routingKey = "order.validated";
        
        public String getExchange() {
            return exchange;
        }
        
        public void setExchange(String exchange) {
            this.exchange = exchange;
        }
        
        public String getRoutingKey() {
            return routingKey;
        }
        
        public void setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
        }
    }
}
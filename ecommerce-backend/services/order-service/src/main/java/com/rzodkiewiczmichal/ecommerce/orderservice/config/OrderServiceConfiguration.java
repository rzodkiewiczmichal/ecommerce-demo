package com.rzodkiewiczmichal.ecommerce.orderservice.config;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.in.PlaceOrderUseCase;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.LoadProductPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.OrderEventPublisher;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.SaveOrderPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.service.PlaceOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfiguration {

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(
            LoadProductPort loadProductPort,
            SaveOrderPort saveOrderPort,
            OrderEventPublisher orderEventPublisher) {
        return new PlaceOrderService(loadProductPort, saveOrderPort, orderEventPublisher);
    }
} 
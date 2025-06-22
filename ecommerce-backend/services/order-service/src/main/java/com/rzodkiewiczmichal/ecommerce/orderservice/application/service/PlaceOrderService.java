package com.rzodkiewiczmichal.ecommerce.orderservice.application.service;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.in.PlaceOrderUseCase;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.LoadProductPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.OrderEventPublisher;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.SaveOrderPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.OrderTotal;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.OrderValidationService;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.PlaceOrderCommand;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceOrderService implements PlaceOrderUseCase {

    private final LoadProductPort loadProductPort;
    private final SaveOrderPort saveOrderPort;
    private final OrderEventPublisher eventPublisher;

    @Override
    public Order placeOrder(PlaceOrderCommand command) {
        OrderValidationService validationService = new OrderValidationService(loadProductPort);
        validationService.validateOrder(command);

        OrderTotal orderTotal = OrderTotal.calculate(
            command.items(), 
            item -> loadProductPort.loadById(item.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + item.productId()))
        );
        Order order = new Order(
            OrderId.generate(),
            command.customerId(),
            command.items(),
            command.deliveryDetails(),
            orderTotal.amount()
        );
        Order savedOrder = saveOrderPort.save(order);
        eventPublisher.publishOrderValidated(savedOrder);
        return savedOrder;
    }
} 
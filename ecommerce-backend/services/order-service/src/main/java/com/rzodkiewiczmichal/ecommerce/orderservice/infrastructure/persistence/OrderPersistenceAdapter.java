package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.LoadOrderPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out.SaveOrderPort;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import com.rzodkiewiczmichal.ecommerce.shared.domain.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements LoadOrderPort, SaveOrderPort {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Optional<Order> loadById(OrderId orderId) {
        return orderRepository.findById(orderId.value())
                .map(orderMapper::toDomain);
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = orderMapper.toEntity(order);
        OrderEntity savedEntity = orderRepository.save(entity);
        return orderMapper.toDomain(savedEntity);
    }
}
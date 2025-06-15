package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.rest;

import com.rzodkiewiczmichal.ecommerce.orderservice.application.port.in.PlaceOrderUseCase;
import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        Order order = placeOrderUseCase.placeOrder(request.toCommand());
        return ResponseEntity.ok(order);
    }
} 
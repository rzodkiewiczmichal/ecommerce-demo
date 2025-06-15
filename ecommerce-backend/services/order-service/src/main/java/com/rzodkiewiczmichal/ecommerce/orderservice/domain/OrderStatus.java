package com.rzodkiewiczmichal.ecommerce.orderservice.domain;

public enum OrderStatus {
    PENDING_VALIDATION,
    VALIDATED,
    INVALID,
    PENDING_PAYMENT
} 
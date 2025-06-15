package com.rzodkiewiczmichal.ecommerce.orderservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.orderservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;

import java.util.Optional;

public interface LoadProductPort {
    Optional<Product> loadById(ProductId productId);
} 
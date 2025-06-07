package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.web;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper {

    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }
        
        return new ProductResponse(
            product.getId().value(),
            product.getName().value(),
            product.getDescription().value(),
            product.getPrice().value()
        );
    }
}
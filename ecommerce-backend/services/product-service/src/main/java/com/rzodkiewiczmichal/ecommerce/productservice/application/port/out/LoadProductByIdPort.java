package com.rzodkiewiczmichal.ecommerce.productservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;

import java.util.Optional;

/**
 * Outbound port: load a single product by its identifier from the persistence layer.
 */
public interface LoadProductByIdPort {
    /**
     * Load a product by its unique identifier.
     * @param productId the ID of the product to load
     * @return an Optional containing the product if found, otherwise empty
     */
    Optional<Product> loadProductById(ProductId productId);
}
package com.rzodkiewiczmichal.ecommerce.productservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;

import java.util.Collection;

/**
 * Outbound port: load all products for customer browsing from the persistence layer.
 */
public interface LoadAllProductsPort {
    /**
     * Load all available products.
     * @return a collection of all products
     */
    Collection<Product> loadAllProducts();
}
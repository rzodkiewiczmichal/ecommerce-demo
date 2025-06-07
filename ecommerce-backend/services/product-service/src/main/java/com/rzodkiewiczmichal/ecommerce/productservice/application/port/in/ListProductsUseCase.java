package com.rzodkiewiczmichal.ecommerce.productservice.application.port.in;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;

import java.util.Collection;

/**
 * Inbound port: list products for customer browsing
 */
public interface ListProductsUseCase {
    /**
     * Retrieve all products for customer browsing.
     *
     * @return collection of all available products
     */
    Collection<Product> listProducts();
}

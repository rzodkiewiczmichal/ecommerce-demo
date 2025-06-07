package com.rzodkiewiczmichal.ecommerce.productservice.application.port.out;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;

import java.util.Collection;

/**
 * Outbound port: load multiple products by their identifiers from the persistence layer.
 */
public interface LoadProductsByIdsPort {
    /**
     * Load a collection of products given their unique identifiers.
     * @param productIds the IDs of the products to load
     * @return a collection of matching products (may be empty)
     */
    Collection<Product> loadProductsByIds(Collection<ProductId> productIds);
}
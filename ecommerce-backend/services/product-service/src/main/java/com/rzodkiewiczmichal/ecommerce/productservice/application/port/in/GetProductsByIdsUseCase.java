package com.rzodkiewiczmichal.ecommerce.productservice.application.port.in;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;

import java.util.Collection;
import java.util.List;

/**
 * Inbound port: retrieve multiple products by their IDs.
 */
public interface GetProductsByIdsUseCase {
    /**
     * Retrieve a list of products given their unique identifiers.
     * @param productIds the list of product IDs to fetch
     * @return list of matching products (may be empty if none found)
     */
    Collection<Product> getProductsByIds(List<ProductId> productIds);
}
package com.rzodkiewiczmichal.ecommerce.productservice.application.port.in;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;
import java.util.Optional;

/**
 * Inbound port: retrieve a single product by ID.
 */
public interface GetProductByIdUseCase {

    /**
     * Retrieve a product by its unique identifier.
     * @param productId the ID of the product
     * @return an Optional containing the product if found, or empty if not
     */
    Optional<Product> getProductById(ProductId productId);
}

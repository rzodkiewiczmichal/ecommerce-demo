package com.rzodkiewiczmichal.ecommerce.productservice.application.port.service;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductByIdUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductByIdPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;

import java.util.Optional;

public class GetProductByIdService implements GetProductByIdUseCase {

    private final LoadProductByIdPort loadProductByIdPort;

    public GetProductByIdService(LoadProductByIdPort loadProductByIdPort) {
        this.loadProductByIdPort = loadProductByIdPort;
    }

    @Override
    public Optional<Product> getProductById(ProductId productId) {
        return loadProductByIdPort.loadProductById(productId);
    }
}

package com.rzodkiewiczmichal.ecommerce.productservice.application.port.service;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductsByIdsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductsByIdsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;

import java.util.List;

public class GetProductsByIdsService implements GetProductsByIdsUseCase {

    private final LoadProductsByIdsPort loadProductsByIdsPort;

    public GetProductsByIdsService(LoadProductsByIdsPort loadProductsByIdsPort) {
        this.loadProductsByIdsPort = loadProductsByIdsPort;
    }

    @Override
    public List<Product> getProductsByIds(List<ProductId> productIds) {
        return List.copyOf(loadProductsByIdsPort.loadProductsByIds(productIds));
    }
}
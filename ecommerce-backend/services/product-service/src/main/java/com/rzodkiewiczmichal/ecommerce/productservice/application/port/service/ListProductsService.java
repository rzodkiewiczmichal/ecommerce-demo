package com.rzodkiewiczmichal.ecommerce.productservice.application.port.service;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.ListProductsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadAllProductsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;

import java.util.Collection;

public class ListProductsService implements ListProductsUseCase {

    private final LoadAllProductsPort loadAllProductsPort;

    public ListProductsService(LoadAllProductsPort loadAllProductsPort) {
        this.loadAllProductsPort = loadAllProductsPort;
    }

    @Override
    public Collection<Product> listProducts() {
        return loadAllProductsPort.loadAllProducts();
    }
}
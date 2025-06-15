package com.rzodkiewiczmichal.ecommerce.productservice.application.port.service;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductsByIdsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductsByIdsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductsByIdsService implements GetProductsByIdsUseCase {

    private final LoadProductsByIdsPort loadProductsByIdsPort;

    @Override
    public List<Product> getProductsByIds(List<ProductId> productIds) {
        return loadProductsByIdsPort.loadByIds(productIds);
    }
}